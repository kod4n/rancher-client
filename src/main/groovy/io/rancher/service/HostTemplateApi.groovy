package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.HostTemplate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface HostTemplateApi {
  @GET('v2-beta/hostTemplates')
  Call<TypeCollection<HostTemplate>> list()

  @GET('v2-beta/hostTemplates')
  Call<TypeCollection<HostTemplate>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/hostTemplates/{id}')
  Call<HostTemplate> findById(@Path('id') String id)

  @POST('v2-beta/hostTemplates/{id}?action=remove')
  Call<HostTemplate> remove(@Path('id') String id)
}
