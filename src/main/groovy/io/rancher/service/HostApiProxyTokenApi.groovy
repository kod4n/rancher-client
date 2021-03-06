package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.HostApiProxyToken
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface HostApiProxyTokenApi {
  @GET('v2-beta/hostApiProxyTokens')
  Call<TypeCollection<HostApiProxyToken>> list()

  @GET('v2-beta/hostApiProxyTokens')
  Call<TypeCollection<HostApiProxyToken>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/hostApiProxyTokens/{id}')
  Call<HostApiProxyToken> findById(@Path('id') String id)
}
