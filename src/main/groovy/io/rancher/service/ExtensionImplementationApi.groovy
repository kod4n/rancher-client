package io.rancher.service

import io.rancher.type.ExtensionImplementation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ExtensionImplementationApi {

  @GET('v2-beta/extensionImplementations/{id}')
  Call<ExtensionImplementation> findById(@Path('id') String id)
}
