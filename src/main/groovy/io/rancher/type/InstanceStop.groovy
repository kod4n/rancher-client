package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class InstanceStop extends RancherType {
  Boolean remove
  BigInteger timeout
}
