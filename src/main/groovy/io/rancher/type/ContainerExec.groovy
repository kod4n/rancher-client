package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ContainerExec extends RancherType {
  Boolean attachStdin
  Boolean attachStdout
  List<String> command
  Boolean tty
}
