package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class HostApiProxyToken extends RancherType {
  String reportedUuid
  String token
  String url
}
