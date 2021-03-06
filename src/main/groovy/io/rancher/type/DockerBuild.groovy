package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class DockerBuild extends RancherType {
  String context
  String dockerfile
  Boolean forcerm
  Boolean nocache
  String remote
  Boolean rm
}
