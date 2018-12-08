package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.AzureConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface AzureConfigApi {

  @POST('v2-beta/azureConfigs')
  Call<AzureConfig> create(@Body AzureConfig azureConfig)

  @GET('v2-beta/azureConfigs/{id}')
  Call<AzureConfig> findById(@Path('id') String id)

}
