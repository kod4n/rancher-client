package io.rancher.base

import groovy.transform.AnnotationCollector
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@Canonical
@CompileStatic
@TupleConstructor(includeSuperProperties = true)
@AnnotationCollector
@interface RancherModel {}
