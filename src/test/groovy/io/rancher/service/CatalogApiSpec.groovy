package io.rancher.service

import groovy.util.logging.Slf4j
import spock.lang.Shared

import static org.hamcrest.Matchers.allOf
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.hasKey
import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.hamcrest.collection.IsEmptyCollection.empty
import static org.hamcrest.core.IsNot.not
import static org.hamcrest.core.IsNull.notNullValue
import static spock.util.matcher.HamcrestSupport.expect

@Slf4j
class CatalogApiSpec extends RancherSpec {
  @Shared CatalogApi catalogApi
  @Shared TemplateApi templateApi

  def setupSpec() {
    catalogApi = rancher.type CatalogApi
    templateApi = rancher.type TemplateApi
  }

  def 'should find catalogs when listing'() {
    when:
    def catalogs = catalogApi.list().execute().body()

    then:
    expect catalogs.data, hasSize(2)
  }

  def 'should find catalog templates when listing'() {
    when:
    def templates = templateApi.list().execute().body()

    then:
    expect templates.data, not(empty())
  }

  def 'should find template by name identifier'() {
    when:
    def healthcheckTemplate = templateApi.findById('library:infra*healthcheck').execute().body()

    then:
    verifyAll {
      expect healthcheckTemplate, notNullValue()
      expect healthcheckTemplate.name, equalTo('Healthcheck Service')
      expect healthcheckTemplate.defaultTemplateVersionId, equalTo('library:infra*healthcheck:5')
      expect healthcheckTemplate.versionLinks.keySet(), hasSize(6)
    }
  }

  def 'should find template by name version identifier'() {
    when:
    def latestHealthcheck = templateApi.findVersionById('library:infra*healthcheck:5').execute().body()

    then:
    verifyAll {
      expect latestHealthcheck, notNullValue()
      expect latestHealthcheck.id, equalTo('library:infra*healthcheck:5')
      expect latestHealthcheck.files, allOf(
        hasKey('README.md'),
        hasKey('docker-compose.yml'),
        hasKey('rancher-compose.yml')
      )
      expect latestHealthcheck.version, equalTo('v0.3.3-1')
    }
  }
}
