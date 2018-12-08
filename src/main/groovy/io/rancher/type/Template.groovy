package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Template implements RancherType {
  Map<String, Object> actions
  String catalogId
  List<String> categories
  String category
  String defaultTemplateVersionId
  String defaultVersion
  String description
  String environmentId
  String folderName
  String iconFilename
  String isSystem
  Map<String, Object> labels
  String license
  Map<String, Object> links
  String maintainer
  String name
  String path
  String templateBase
  String type
  String upgradeFrom
  Map<String, Object> versionLinks
  List<String> versions
}
