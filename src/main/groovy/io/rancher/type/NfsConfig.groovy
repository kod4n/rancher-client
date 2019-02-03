package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class NfsConfig extends RancherType {
  String server
  String share
  String mountOptions
}
