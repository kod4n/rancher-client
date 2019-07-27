package io.rancher.service

import io.rancher.type.Project
import io.rancher.type.Stack as RancherStack
import spock.lang.Shared
import spock.lang.Stepwise

import static io.rancher.Rancher.extractBody
import static org.hamcrest.Matchers.*
import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.hamcrest.collection.IsEmptyCollection.empty
import static org.hamcrest.core.IsNot.not
import static org.hamcrest.core.IsNull.notNullValue
import static spock.util.matcher.HamcrestSupport.expect

@Stepwise
class ProjectApiSpec extends RancherSpec {
  @Shared ProjectApi projects
  @Shared Project defaultProject

  def setupSpec() {
    projects = rancher.type ProjectApi
    defaultProject = extractBody projects.list() data[0]
  }

  def 'should find projects when listing'() {
    when:
    def projects = projects.list().execute().body()

    then:
    expect projects.data, not(empty())
  }

  def 'querying by project name is successful'() {
    when:
    def byName = projects.query(name: defaultProject.name).execute().body()

    then:
    expect byName.data, hasSize(1)
    expect byName.data.first().name, equalTo(defaultProject.name)
  }

  def 'finding project by id is successful'() {
    when:
    def byId = projects.findById(defaultProject.id).execute().body()

    then:
    expect byId, notNullValue()
    expect byId.id, equalTo(defaultProject.id)
    expect byId.name, equalTo(defaultProject.name)
  }

  def 'should create a stack'() {
    given:
    def stack = new RancherStack(
      name: 'test-stack',
      dockerCompose: /version: '2'
                     |services:
                     |  hello:
                     |    image: tutum\/hello-world/
    )

    when:
    def response = projects.createStack(defaultProject.id, stack).execute()

    then:
    expect response.code(), equalTo(201)
    expect response.body(), allOf(
      hasProperty('name', equalTo('test-stack')),
      hasProperty('dockerCompose', containsString('image: tutum/hello-world'))
    )
  }

  def 'should find a stack by query'() {
    given:
    def stackName = 'test-stack'

    when:
    def stackQuery = extractBody projects.queryStacks(defaultProject.id, [name: stackName]) data

    then:
    expect stackQuery, hasSize(1)
    with(stackQuery.first()) {
      expect name, equalTo(stackName)
      expect dockerCompose, not(isEmptyOrNullString())
    }
  }

  def 'should delete a stack by id'() {
    given:
    def stackQuery = extractBody projects.queryStacks(defaultProject.id, [name: 'test-stack']) data
    def stack = stackQuery.first()

    when:
    def result = projects.deleteStack(defaultProject.id, stack.id).execute()

    then:
    expect result.code(), equalTo(200)
  }
}
