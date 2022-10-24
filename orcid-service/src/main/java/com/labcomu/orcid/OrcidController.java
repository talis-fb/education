package com.labcomu.orcid;

import com.labcomu.faultinjection.annotation.Delay;
import com.labcomu.faultinjection.annotation.Mutate;
import com.labcomu.faultinjection.api.Mutator;
import com.labcomu.orcid.resource.Researcher;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/orcid")
@Validated
@RequiredArgsConstructor
public class OrcidController {
  private final OrcidService service;

  @GetMapping("active")
  @Delay(seconds = 10)
  public boolean isActive() {
    return service.isActive();
  }

  @GetMapping("researcher/{orcid}")
  @Mutate(ResearcherMutator.class)
  public Researcher getResearcher(@NotNull @PathVariable String orcid) {
    return service.getResearcher(orcid);
  }

  public static class ResearcherMutator implements Mutator<Researcher> {
    @Override
    public void mutate(Researcher researcher) {
      researcher.setName(researcher.getName() + " [MUTATE]");
    }
  }
}
