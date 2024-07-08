ALTER TABLE vollmed_api.medicos ADD COLUMN activo TINYINT(1);
UPDATE vollmed_api.medicos SET activo = 1;