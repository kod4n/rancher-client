package io.rancher.service

import io.rancher.type.Ulimit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UlimitApi {

  @GET('v2-beta/ulimits/{id}')
  Call<Ulimit> findById(@Path('id') String id)
}
