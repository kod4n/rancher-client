package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ChangeSecretInput extends RancherType {
  String oldSecret
  String newSecret
}
