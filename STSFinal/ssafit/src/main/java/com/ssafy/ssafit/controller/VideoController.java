package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

@RestController
@RequestMapping("/video")
@CrossOrigin("*")
public class VideoController {

	VideoService videoService;
	
	@Autowired
	public VideoController(VideoService videoService) {
		this.videoService = videoService;
	}
	
	//메인화면에 보여지는 기본 영화 리스트
	@GetMapping
	public ResponseEntity<List<Video>> searchAll() {
		List<Video> list = videoService.searchAll();
		
		if(list.size() == 0 || list == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}
	
	//youtubeId로 영화 하나만 검색 ( detail 들어갈 때 필요 )
	@GetMapping("/detail/{youtubeId}")
	public ResponseEntity<Video> searchOne(@PathVariable String youtubeId) {
		Video video = videoService.searchOne(youtubeId);
		
		if(video == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(video, HttpStatus.OK);
		}
	}
	
//	//keyword가 포함된 영화들을 검색 ( 검색창에 keyword로 검색할 때 필요)
//	@GetMapping("/{keyword}")
//	public ResponseEntity<List<Video>> searchByTitle(@PathVariable String keyword) {
//		List<Video> list = videoService.searchByTitle(keyword);
//		
//		if(list.size() == 0 || list == null) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}else {
//			return new ResponseEntity<>(list, HttpStatus.OK);
//		}
//	}
	
	//youtubeId로 DB에 이 영상관련 정보가 이미 있는지 확인한다.
	@PostMapping("/check")
	public ResponseEntity<?> searchByYoutubeId(String youtubeId){
		Video video = videoService.searchByYoutubeId(youtubeId);
		
		if(video == null) {
			return new ResponseEntity<>(1, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(video, HttpStatus.FOUND);
		}
	}
	
	//영상 관련 정보가 없다면 새로 영상 정보를 DB에 저장한다.
	@PostMapping
	public ResponseEntity<String> registVideo(@RequestBody Video video) {
		System.out.println(video);
		if(videoService.registVideo(video) == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
