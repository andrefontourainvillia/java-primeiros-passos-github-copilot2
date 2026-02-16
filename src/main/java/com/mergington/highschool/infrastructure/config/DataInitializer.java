package com.mergington.highschool.infrastructure.config;

import com.mergington.highschool.domain.entity.Activity;
import com.mergington.highschool.domain.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Component to initialize the database with sample activities.
 * Runs at application startup.
 */
@Component
public class DataInitializer implements CommandLineRunner {
    
    private final ActivityRepository activityRepository;
    
    public DataInitializer(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    
    @Override
    public void run(String... args) {
        // Only initialize if no activities exist
        if (activityRepository.findAll().isEmpty()) {
            initializeActivities();
        }
    }
    
    private void initializeActivities() {
        // Create Chess Club
        Activity chessClub = new Activity(
                "Clube de Xadrez",
                "Aprenda estratégias e participe de torneios de xadrez",
                "Sextas, 15h30 - 17h",
                12
        );
        chessClub.setParticipants(Arrays.asList("michael@mergington.edu", "daniel@mergington.edu"));
        
        // Create Programming Class
        Activity programmingClass = new Activity(
                "Aula de Programação",
                "Aprenda fundamentos de programação e desenvolva projetos de software",
                "Terças e quintas, 15h30 - 16h30",
                20
        );
        programmingClass.setParticipants(Arrays.asList("emma@mergington.edu", "sophia@mergington.edu"));
        
        // Create Physical Education
        Activity physicalEducation = new Activity(
                "Educação Física",
                "Educação física e atividades esportivas",
                "Segundas, quartas e sextas, 14h - 15h",
                30
        );
        physicalEducation.setParticipants(Arrays.asList("john@mergington.edu", "olivia@mergington.edu"));
        
        // Create Basketball Team
        Activity basketball = new Activity(
                "Equipe de Basquete",
                "Treine e compete em jogos de basquete inter-escolares",
                "Terças e quintas, 16h - 18h",
                15
        );
        basketball.setParticipants(Arrays.asList("lucas@mergington.edu", "pedro@mergington.edu"));

        // Create Swimming Club
        Activity swimming = new Activity(
                "Clube de Natação",
                "Aprenda técnicas de natação e participe de competições",
                "Segundas e quartas, 16h - 17h30",
                18
        );
        swimming.setParticipants(Arrays.asList("ana@mergington.edu", "julia@mergington.edu"));

        // Create Theater Workshop
        Activity theater = new Activity(
                "Oficina de Teatro",
                "Desenvolva habilidades de atuação e participe de peças teatrais",
                "Quartas, 15h30 - 17h30",
                16
        );
        theater.setParticipants(Arrays.asList("isabella@mergington.edu", "gabriel@mergington.edu"));

        // Create Arts and Painting
        Activity arts = new Activity(
                "Arte e Pintura",
                "Explore diferentes técnicas de pintura e expressão artística",
                "Sextas, 14h - 16h",
                14
        );
        arts.setParticipants(Arrays.asList("maria@mergington.edu", "rafael@mergington.edu"));

        // Create Science Club
        Activity scienceClub = new Activity(
                "Clube de Ciências",
                "Realize experimentos científicos e projetos de pesquisa",
                "Terças, 15h30 - 17h",
                15
        );
        scienceClub.setParticipants(Arrays.asList("sofia@mergington.edu", "miguel@mergington.edu"));

        // Create Debate Club
        Activity debateClub = new Activity(
                "Clube de Debate",
                "Desenvolva habilidades de argumentação e participe de competições de debate",
                "Quintas, 15h30 - 17h",
                12
        );
        debateClub.setParticipants(Arrays.asList("laura@mergington.edu", "thomas@mergington.edu"));

        // Save activities
        activityRepository.save(chessClub);
        activityRepository.save(programmingClass);
        activityRepository.save(physicalEducation);
        activityRepository.save(basketball);
        activityRepository.save(swimming);
        activityRepository.save(theater);
        activityRepository.save(arts);
        activityRepository.save(scienceClub);
        activityRepository.save(debateClub);

        System.out.println("Database initialized with sample activities");
    }
}