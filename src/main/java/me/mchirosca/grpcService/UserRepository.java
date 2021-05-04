package me.mchirosca.grpcService;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface UserRepository extends DatastoreRepository<UserEntity, String> {
}
