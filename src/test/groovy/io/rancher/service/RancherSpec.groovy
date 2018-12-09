package io.rancher.service

import io.rancher.Rancher
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import spock.lang.Specification

import java.time.Duration

abstract class RancherSpec extends Specification {
  Rancher rancher

  static GenericContainer rancherServer = new GenericContainer('rancher/enterprise:v1.6.14')
    .withExposedPorts(8080)
    .withStartupTimeout(Duration.ofMinutes(5L))

  static {
    rancherServer.start()
  }

  def setupSpec() {
    rancherServer.followOutput(new Slf4jLogConsumer(log))
  }

  def setup() {
    def url = rancherServer.with {
      "http://${containerIpAddress}:${firstMappedPort}/"
    }
    rancher = new Rancher(new Rancher.Config(url: url.toURL()))
  }
}
