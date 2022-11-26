package com.labcomu.edu;

import com.labcomu.edu.resource.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/edu")
@Validated
@RequiredArgsConstructor
public class EduController {
  private final EduService service;

  @GetMapping("organization/{url}")
  @CircuitBreaker(name="eduService", fallbackMethod = "fallbackOrgService")
  public Organization getOrganization(@NotNull @PathVariable String url) {
    return service.getOrganization(url);
  }

  public Organization fallbackOrgService (Exception e){
    System.out.println("[=== ERROR ===] -> OrgService is down");
    throw new ResponseStatusException(
            HttpStatus.BAD_GATEWAY,
            "Org-Service not avaible"
    );
  }
}
