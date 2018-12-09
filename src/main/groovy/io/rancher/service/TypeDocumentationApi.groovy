package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.TypeDocumentation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TypeDocumentationApi {
  @GET('v2-beta/typeDocumentations')
  Call<TypeCollection<TypeDocumentation>> list()

  @GET('v2-beta/typeDocumentations')
  Call<TypeCollection<TypeDocumentation>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/typeDocumentations/{id}')
  Call<TypeDocumentation> findById(@Path('id') String id)
}
