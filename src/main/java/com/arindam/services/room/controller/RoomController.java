package com.arindam.services.room.controller;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.services.room.entity.Room;
import com.arindam.services.room.repository.RoomRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rooms")
@Api(value="rooms", description="Data service operations for rooms", tags="rooms")
public class RoomController {
	@Autowired
	RoomRepository roomRepository;
	
	@GetMapping
	@ApiOperation(value="Get All Rooms", notes="Get All Rooms in the system",nickname="getRooms")
	public List<Room> findAll(@RequestParam(name="roomNumber", required=false)String roomNumber){
		if(StringUtils.isNotEmpty(roomNumber)) {
			return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
		}
		return this.roomRepository.findAll();
	}

}
