package io.rancher.service

import io.rancher.type.FieldDocumentation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FieldDocumentationApi {

  @GET('v2-beta/fieldDocumentations/{id}')
  Call<FieldDocumentation> findById(@Path('id') String id)
}
