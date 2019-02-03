package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class NetworkPolicyRuleBetween extends RancherType {
  String groupBy
  String selector
}
