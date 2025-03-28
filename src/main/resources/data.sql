CREATE TABLE IF NOT EXISTS tarefas (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(9) NOT NULL CHECK (status IN ('PENDENTE', 'CONCLUIDA')),
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_conclusao TIMESTAMP,

    CONSTRAINT validacao_status_conclusao
        CHECK ((status = 'CONCLUIDA' AND data_conclusao IS NOT NULL) OR
               (status = 'PENDENTE' AND data_conclusao IS NULL))
);

COMMENT ON COLUMN tarefas.id IS 'Identificador único gerado automaticamente';
COMMENT ON COLUMN tarefas.titulo IS 'Título obrigatório da tarefa';
COMMENT ON COLUMN tarefas.descricao IS 'Descrição opcional da tarefa';
COMMENT ON COLUMN tarefas.status IS 'Status da tarefa: PENDENTE ou CONCLUIDA';
COMMENT ON COLUMN tarefas.data_criacao IS 'Data de criação gerada automaticamente';
COMMENT ON COLUMN tarefas.data_conclusao IS 'Data de conclusão (apenas para tarefas concluídas)';