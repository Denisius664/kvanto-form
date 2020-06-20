package inc.sneid.kvantoForm.repo;

import inc.sneid.kvantoForm.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
