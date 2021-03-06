package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class RestartPolicy extends RancherType {
  BigInteger maximumRetryCount
  String name
}
