package com.example.eglise.impl;

import com.example.eglise.dto.request.AdresseRequest;
import com.example.eglise.dto.request.InscriptionFamilleRequest;
import com.example.eglise.dto.request.MariageRequest;
import com.example.eglise.dto.request.PersonRequest;
import com.example.eglise.entity.*;
import com.example.eglise.enums.RoleFamille;
import com.example.eglise.enums.TitulaireCompte;
import com.example.eglise.repository.*;
import com.example.eglise.services.InscriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    private final AdresseRepository adresseRepository;
    private final PersonneRepository personneRepository;
    private final FamilleRepository familleRepository;
    private final MembreFamilleRepository membreFamilleRepository;
    private final MariageRepository mariageRepository;
    private final EgliseUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final GenreRepository genreRepository;
    private final SakrametaRepository sakrametaRepository;
    private final PersonSakrametaRepository personSakrametaRepository;
    private final FikambananaRepository fikambananaRepository;
    private final PersonFikambananaRepository personFikambananaRepository;
    private final VaomieraRepository vaomieraRepository;
    private final PersonVaomieraRepository personVaomieraRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void inscrire(
            InscriptionFamilleRequest request
    ) {
        // adresse
        Adresse adresse = creerAdresse(request.getAdresse());

        // pere et mere
        Personne pere = createPerson(request.getPere());
        Personne mere = createPerson(request.getMere());

        // famille
        Famille famille = creerFamille(request, adresse, pere, mere);

        // membre famille
        ajouterMembre(famille, pere, RoleFamille.PERE);
        ajouterMembre(famille, mere, RoleFamille.MERE);

        // mariage
        creerMariage(request.getMariage(), pere, mere);

        // enfants
        if (request.getEnfants() != null) {
            request.getEnfants().forEach(e -> {
                Personne enfant = createPerson(e);
                ajouterMembre(famille, enfant, RoleFamille.ENFANT);
            });
        }

        // user
        createUser(request.getTitulaireCompte(), pere, mere);
    }

    private Adresse creerAdresse(AdresseRequest dto) {

        Adresse a = Adresse.builder()
                .lot(dto.getLot())
                .toerana(dto.getToerana())
                .fokontany(dto.getFokontany())
                .commune(dto.getCommune())
                .apv(dto.getApv())
                .createdAt(LocalDateTime.now())
                .build();

        return adresseRepository.save(a);
    }

    private Personne createPerson(
            PersonRequest dto
    ){
        Genre genre = genreRepository.findById(
                dto.getGenreId()
        ).orElseThrow();

        Personne personne = Personne.builder()
                .anarana(dto.getAnarana())
                .fanampiny(dto.getFanampiny())
                .dateNaissance(dto.getDateNaissance())
                .telephone(dto.getTelephone())
                .email(dto.getEmail())
                .metier(dto.getMetier())
                .nomPere(dto.getNomPere())
                .nomMere(dto.getNomMere())
                .estMort(
                        dto.getEstMort() != null
                                ? dto.getEstMort() : false
                )
                .genre(genre)
                .createdAt(LocalDateTime.now())
                .build();

        personne = personneRepository.save(personne);
        saveSakrameta(personne, dto);
        saveFikambanana(personne, dto);
        saveVaomiera(personne, dto);
        return personne;
    }

    private Famille creerFamille(
            InscriptionFamilleRequest request,
            Adresse adresse,
            Personne pere,
            Personne mere
    ) {

        Famille f = Famille.builder()
                .nomFamille(request.getFamille().getNomFamille())
                .itompokolahy(request.getFamille().getItompokolahy())
                .itompokovavy(request.getFamille().getItompokovavy())
                .solotena(request.getFamille().getSolotena())
                .telephone(request.getFamille().getTelephone())
                .adresse(adresse)
                .responsable(
                        request.getTitulaireCompte() == TitulaireCompte.PERE
                                ? pere
                                : mere
                )
                .createdAt(LocalDate.now())
                .build();

        return familleRepository.save(f);
    }

    private void ajouterMembre(
            Famille famille,
            Personne personne,
            RoleFamille role
    ) {

        MembreFamille mf = MembreFamille.builder()
                .famille(famille)
                .personne(personne)
                .role(role)
                .build();

        membreFamilleRepository.save(mf);
    }

    private void creerMariage(
            MariageRequest dto,
            Personne pere,
            Personne mere
    ) {

        Mariage m = Mariage.builder()
                .person1(pere)
                .person2(mere)
                .dateReligieux(dto.getDateReligieux())
                .dateCivil(dto.getDateCivil())
                .isCatholic(dto.getCatholic())
                .churchName(dto.getChurchName())
                .estDivorce(dto.getDivorce())
                .build();

        mariageRepository.save(m);
    }

    private void saveSakrameta(Personne p, PersonRequest dto) {

        if (dto.getSakrametaIds() == null) return;

        dto.getSakrametaIds().forEach(id -> {

            Sakrameta s = sakrametaRepository.findById(id)
                    .orElseThrow();

            PersonSakrameta ps = new PersonSakrameta();
            ps.setPersonne(p);
            ps.setSakrameta(s);
            ps.setDateVoray(LocalDate.now());

            personSakrametaRepository.save(ps);
        });
    }

    private void saveFikambanana(Personne p, PersonRequest dto) {

        if (dto.getFikambananaIds() == null) return;

        dto.getFikambananaIds().forEach(id -> {

            Fikambanana f = fikambananaRepository.findById(id)
                    .orElseThrow();

            PersonFikambanana pf = new PersonFikambanana();
            pf.setPersonne(p);
            pf.setFikambanana(f);
            pf.setJoinedAt(LocalDate.now());

            personFikambananaRepository.save(pf);
        });
    }

    private void saveVaomiera(Personne p, PersonRequest dto) {

        if (dto.getVaomieraIds() == null) return;

        dto.getVaomieraIds().forEach(id -> {

            Vaomiera v = vaomieraRepository.findById(id)
                    .orElseThrow();

            PersonVaomiera pv = new PersonVaomiera();
            pv.setPersonne(p);
            pv.setVaomiera(v);
            pv.setJoinedAt(LocalDate.now());

            personVaomieraRepository.save(pv);
        });
    }

    private void createUser(
            TitulaireCompte titulaire,
            Personne pere,
            Personne mere
    ){
        Personne p = (titulaire == TitulaireCompte.PERE) ? pere : mere;

        Role role = roleRepository.findByNom("CROYANT")
                .orElseThrow();

        String rawPassword = "Eglise123";
        String hash = passwordEncoder.encode(rawPassword);

        EgliseUser user = EgliseUser.builder()
                .username(p.getTelephone())
                .password(hash)
                .isActive(true)
                .role(role)
                .personne(p)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}