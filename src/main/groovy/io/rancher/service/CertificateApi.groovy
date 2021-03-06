package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Certificate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface CertificateApi {
  @GET('v2-beta/certificates')
  Call<TypeCollection<Certificate>> list()

  @GET('v2-beta/certificates')
  Call<TypeCollection<Certificate>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/certificates/{id}')
  Call<Certificate> findById(@Path('id') String id)

  @POST('v2-beta/certificates/{id}?action=remove')
  Call<Certificate> remove(@Path('id') String id)
}
