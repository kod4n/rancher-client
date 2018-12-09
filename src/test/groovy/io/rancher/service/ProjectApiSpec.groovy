package io.rancher.service

import groovy.util.logging.Slf4j

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.hamcrest.collection.IsEmptyCollection.empty
import static org.hamcrest.core.IsNot.not
import static org.hamcrest.core.IsNull.notNullValue
import static spock.util.matcher.HamcrestSupport.expect

@Slf4j
class ProjectApiSpec extends RancherSpec {
  def 'should find projects when listing'() {
    given:
    def projectApi = rancher.type ProjectApi

    when:
    def projects = projectApi.list().execute().body()

    then:
    expect projects.data, not(empty())
  }

  def 'querying by project name is successful'() {
    given:
    def projectApi = rancher.type ProjectApi
    def project = projectApi.list().execute().body().data[0]

    when:
    def byName = projectApi.query(name: project.name).execute().body()

    then:
    expect byName.data, hasSize(1)
    expect byName.data.first().name, equalTo(project.name)
  }

  def 'finding project by id is successful'() {
    given:
    def projectApi = rancher.type ProjectApi
    def project = projectApi.list().execute().body().data[0]

    when:
    def byId = projectApi.findById(project.id).execute().body()

    then:
    expect byId, notNullValue()
    expect byId.id, equalTo(project.id)
    expect byId.name, equalTo(project.name)
  }
}
