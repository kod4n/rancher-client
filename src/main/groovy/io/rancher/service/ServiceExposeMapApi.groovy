package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ServiceExposeMap
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ServiceExposeMapApi {
  @GET('v2-beta/serviceExposeMaps')
  Call<TypeCollection<ServiceExposeMap>> list()

  @GET('v2-beta/serviceExposeMaps')
  Call<TypeCollection<ServiceExposeMap>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/serviceExposeMaps/{id}')
  Call<ServiceExposeMap> findById(@Path('id') String id)

  @POST('v2-beta/serviceExposeMaps/{id}?action=remove')
  Call<ServiceExposeMap> remove(@Path('id') String id)
}
