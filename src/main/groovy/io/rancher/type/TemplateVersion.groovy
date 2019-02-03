package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class TemplateVersion extends RancherType {
  Map<String, Object> actions
  Map<String, Object> bindings
  Map<String, Object> files
  Map<String, Object> labels
  Map<String, Object> links
  String maximumRancherVersion
  String minimumRancherVersion
  List<Question> questions
  String templateId
  String type
  String upgradeFrom
  Map<String, Object> upgradeVersionLinks
  String version
}
