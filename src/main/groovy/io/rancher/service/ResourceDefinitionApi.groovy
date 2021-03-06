package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ResourceDefinition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ResourceDefinitionApi {
  @GET('v2-beta/resourceDefinitions')
  Call<TypeCollection<ResourceDefinition>> list()

  @GET('v2-beta/resourceDefinitions')
  Call<TypeCollection<ResourceDefinition>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/resourceDefinitions/{id}')
  Call<ResourceDefinition> findById(@Path('id') String id)
}
