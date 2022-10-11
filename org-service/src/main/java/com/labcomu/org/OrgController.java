package com.labcomu.org;

import com.labcomu.org.domain.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/org")
@Validated
@RequiredArgsConstructor
public class OrgController {
  private final OrgService service;

  @GetMapping("organization/{url}")
  public Organization getOrganization(@NotNull @PathVariable String url) {
    return service.getOrganization(url);
  }
}
