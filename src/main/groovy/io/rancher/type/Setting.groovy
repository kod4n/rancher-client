package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Setting extends RancherType {
  String name
  String value
  String activeValue
  String source
  Boolean inDb
}
