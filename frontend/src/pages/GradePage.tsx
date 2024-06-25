import { styled, Typography } from '@mui/joy';
import { useAtom } from 'jotai/index';
import { AlternateButton } from '../components/AlternateButton.tsx';
import { ContentSection } from '../components/ContentSection.tsx';
import { GradeCard } from '../components/GradeCard.tsx';
import { useGetGradesForSchoolQuery } from '../state/api/grades.ts';
import { whoamiAtom } from '../state/api/whoami.ts';

export function GradePage() {
  const [{ data: whoami }] = useAtom(whoamiAtom);
  const grades = useGetGradesForSchoolQuery(whoami.schools[0].id);

  return (
    <ContentSection>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '40px' }}>
        <Typography level="h3" margin={0} lineHeight={1}>
          Klassenübersicht
        </Typography>
        <AlternateButton>Klasse hinzufügen</AlternateButton>
      </div>

      <GradesCardWrapper>
        {grades?.map((gradeDetailsDto) => {
          return (
            <GradeCard
              key={gradeDetailsDto.grades.name}
              className={gradeDetailsDto.grades.name}
              teacherCount={gradeDetailsDto.teachers.length}
              studentCount={gradeDetailsDto.students.length}
            />
          );
        })}
        {grades && grades.length % 3 === 2 && <EmptyItem />}
      </GradesCardWrapper>
    </ContentSection>
  );
}

const GradesCardWrapper = styled('div')`
  display: flex;
  flex-wrap: wrap;
  align-items: stretch;
  justify-content: space-between;
  gap: 30px;
  width: 100%;
`;

const EmptyItem = styled('div')`
  width: 360px;
`;
