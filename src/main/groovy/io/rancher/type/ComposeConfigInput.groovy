package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ComposeConfigInput extends RancherType {
  List<String> serviceIds
}
