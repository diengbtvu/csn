package com.javaweb.repository;

import com.javaweb.repository.entity.ApartmentEntity;
import com.javaweb.repository.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
    // Lấy danh sách tất cả các căn hộ.
    List<ApartmentEntity> findAll();

    // Lấy thông tin chi tiết của một căn hộ theo id.
    Optional<ApartmentEntity> findById(Long id);

    // Tạo mới hoặc cập nhật một căn hộ.
    ApartmentEntity save(ApartmentEntity apartment);

    // Xóa một căn hộ theo id.
    void deleteById(Long id);

    // Lấy danh sách các hợp đồng thuê của căn hộ theo id.
    @Query("SELECT c FROM ContractEntity c WHERE c.apartment.id = :apartmentId")
    List<ContractEntity> findContractsByApartmentId(@Param("apartmentId") Long apartmentId);

    // Lấy danh sách các căn hộ theo id của tòa nhà.
    @Query("SELECT a FROM ApartmentEntity a WHERE a.building.id = :buildingId")
    List<ApartmentEntity> findByBuildingId(@Param("buildingId") Long buildingId);
}