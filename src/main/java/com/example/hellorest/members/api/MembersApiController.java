package com.example.hellorest.members.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellorest.members.model.Member;
import com.example.hellorest.members.service.MembersService;
import com.example.hellorest.response.ApiDataResponse;
import com.example.hellorest.response.ApiResponse;

@RestController
public class MembersApiController {

	@Autowired
	private MembersService membersService;

	@PostMapping("/members")
	public ApiResponse createMembers(@Valid @RequestBody Member member, Errors errors) {

		if (errors.hasErrors()) {
			String messages = errors.getFieldErrors().stream().map((error) -> error.getDefaultMessage())
					.collect(Collectors.joining("\n"));
			return new ApiResponse("Failed", messages);
		}

		this.membersService.save(member);
		return new ApiDataResponse("OK", member, "");
	}

	@GetMapping("/members")
	public ApiDataResponse getAllMembers() {
		List<Member> allMembers = this.membersService.getAll();
		return new ApiDataResponse("OK", allMembers, "");
	}

	@PutMapping("/members/{id}")
	public ApiDataResponse updateOneMember(@PathVariable long id, @RequestBody Member member) {
		Member oneMember = this.membersService.updateOne(id, member);
		return new ApiDataResponse("OK", oneMember, "");
	}

	@GetMapping("/members/{id}")
	public ApiDataResponse selectOneMember(@PathVariable long id) {
		Member oneMember = this.membersService.getOne(id);
		return new ApiDataResponse("OK", oneMember, "");
	}

	@DeleteMapping("/members/{id}")
	public ApiResponse deleteOneMember(@PathVariable long id) {
		this.membersService.removeOne(id);
		return new ApiResponse("OK", "");
	}

}
