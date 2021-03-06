package io.rancher.service

import io.rancher.type.CatalogTemplate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogTemplateApi {

  @GET('v2-beta/catalogTemplates/{id}')
  Call<CatalogTemplate> findById(@Path('id') String id)
}
