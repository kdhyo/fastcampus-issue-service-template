package com.fastcampus.issueservice.web

import com.fastcampus.issueservice.config.AuthUser
import com.fastcampus.issueservice.domain.enums.IssueStatus
import com.fastcampus.issueservice.model.IssueRequest
import com.fastcampus.issueservice.service.IssueService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
	private val issueService: IssueService
) {

	@PostMapping
	fun create(
		authUser: AuthUser,
		@RequestBody request: IssueRequest,
	) = issueService.create(authUser.userId, request)

	@GetMapping
	fun getAll(
		authUser: AuthUser,
		@RequestParam(required = false, defaultValue = "TODO") status: IssueStatus,
	) = issueService.getAll(status)

}
