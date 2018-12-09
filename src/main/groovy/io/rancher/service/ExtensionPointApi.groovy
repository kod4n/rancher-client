package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExtensionPoint
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExtensionPointApi {
  @GET('v2-beta/extensionPoints')
  Call<TypeCollection<ExtensionPoint>> list()

  @GET('v2-beta/extensionPoints')
  Call<TypeCollection<ExtensionPoint>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/extensionPoints/{id}')
  Call<ExtensionPoint> findById(@Path('id') String id)
}
