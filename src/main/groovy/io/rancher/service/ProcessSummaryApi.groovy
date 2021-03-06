package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProcessSummary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProcessSummaryApi {
  @GET('v2-beta/processSummary')
  Call<TypeCollection<ProcessSummary>> list()

  @GET('v2-beta/processSummary')
  Call<TypeCollection<ProcessSummary>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/processSummary/{id}')
  Call<ProcessSummary> findById(@Path('id') String id)
}
