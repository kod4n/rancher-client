package io.rancher.service

import io.rancher.Rancher
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.output.OutputFrame
import org.testcontainers.containers.output.Slf4jLogConsumer
import org.testcontainers.containers.output.ToStringConsumer
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy
import org.testcontainers.containers.wait.strategy.Wait
import spock.lang.Shared
import spock.lang.Specification

import java.time.Duration

import static org.testcontainers.containers.output.OutputFrame.OutputType.STDERR
import static org.testcontainers.containers.output.OutputFrame.OutputType.STDOUT
import static org.testcontainers.containers.wait.strategy.Wait.forLogMessage

abstract class RancherSpec extends Specification {
  @Shared Rancher rancher
  static final STARTUP_TIMEOUT = Duration.ofMinutes 5

  static GenericContainer rancherServer = new GenericContainer('rancher/enterprise:v1.6.14')
    .withExposedPorts(8080)
    .withStartupTimeout(STARTUP_TIMEOUT)

  static {
    rancherServer.start()
  }

  def setupSpec() {
    rancherServer.with {
      waitingFor(forLogMessage('.*Creating schema host.*', 1).withStartupTimeout(STARTUP_TIMEOUT))
      followOutput(new ToStringConsumer(), STDOUT, STDERR)
      rancher = new Rancher(new Rancher.Config(
        url: "http://${containerIpAddress}:${firstMappedPort}".toURL()
      ))
    }
  }
}
