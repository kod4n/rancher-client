package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Template
import io.rancher.type.TemplateVersion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TemplateApi {
  @GET('v1-catalog/templates')
  Call<TypeCollection<Template>> list()

  @GET('v1-catalog/templates')
  Call<TypeCollection<Template>> query(@QueryMap Map<String, String> filters)

  @GET('v1-catalog/templates/{id}')
  Call<Template> findById(@Path('id') String id)

  @GET('v1-catalog/templates/{id}')
  Call<TemplateVersion> findVersionById(@Path('id') String id)
}
