import styled from 'styled-components';
import BoardButtons from '../../components/board/BoardButtons';
import BoardEditor from '../../components/board/BoardEditor';
import BoardTag from '../../components/board/BoardTag';
import BoardTitle from '../../components/board/BoardTitle';

function BoardTemplate() {
    return (
        <>
            <StyledBoardTemplate>
                <Block>
                    <BoardTitle />
                    <BoardTag />
                </Block>
                <BoardEditor />
                <BoardButtons />
            </StyledBoardTemplate>
        </>
    );
}

const StyledBoardTemplate = styled.div`
    min-height: 0px;
    display: flex;
    flex-direction: column;
`;

const Block = styled.div`
    max-height: 450px;
    padding: 1rem;
`;

export default BoardTemplate;
