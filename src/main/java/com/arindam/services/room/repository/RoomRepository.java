package com.arindam.services.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arindam.services.room.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	public Room findByRoomNumber(String roomNumber);
}
