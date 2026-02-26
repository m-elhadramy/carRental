ALTER TABLE sys_menu_roles
    ADD CONSTRAINT uq_menu_role UNIQUE (menu_id, role);

-- ==============================
-- VOITURES
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Voitures' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Voitures', NULL, 1, NULL);

DECLARE @voitures_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Voitures' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/voitures')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste des voitures', '/voitures', 1, @voitures_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/voitures/add')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Ajouter voiture', '/voitures/add', 2, @voitures_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/voitures/disponibles')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Voitures disponibles', '/voitures/disponibles', 3, @voitures_id);


-- ==============================
-- CLIENTS
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Clients' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Clients', NULL, 2, NULL);

DECLARE @clients_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Clients' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/clients')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste des clients', '/clients', 1, @clients_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/clients/add')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Ajouter client', '/clients/add', 2, @clients_id);


-- ==============================
-- LOCATIONS
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Locations' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Locations', NULL, 3, NULL);

DECLARE @locations_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Locations' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/locations')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste des locations', '/locations', 1, @locations_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/locations/add')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Nouvelle location', '/locations/add', 2, @locations_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/locations/actives')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Locations actives', '/locations/actives', 3, @locations_id);


-- ==============================
-- VENTES
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Ventes' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Ventes', NULL, 4, NULL);

DECLARE @ventes_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Ventes' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/ventes')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste des ventes', '/ventes', 1, @ventes_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/ventes/add')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Nouvelle vente', '/ventes/add', 2, @ventes_id);


-- ==============================
-- DEPENSES
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Dépenses' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Dépenses', NULL, 5, NULL);

DECLARE @depenses_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Dépenses' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/depenses')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste des dépenses', '/depenses', 1, @depenses_id);


-- ==============================
-- MAINTENANCE
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Maintenance' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Maintenance', NULL, 6, NULL);

DECLARE @maintenance_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Maintenance' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/maintenance')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Liste maintenance', '/maintenance', 1, @maintenance_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/maintenance/add')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Ajouter maintenance', '/maintenance/add', 2, @maintenance_id);


-- ==============================
-- COMPTABILITE
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Comptabilité' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Comptabilité', NULL, 7, NULL);

DECLARE @compta_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Comptabilité' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/comptabilite/revenus')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Revenus', '/comptabilite/revenus', 1, @compta_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/comptabilite/depenses')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Dépenses comptables', '/comptabilite/depenses', 2, @compta_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/comptabilite/rapports')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Rapports', '/comptabilite/rapports', 3, @compta_id);


-- ==============================
-- ADMIN
-- ==============================

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE label = 'Administration' AND parent_id IS NULL)
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Administration', NULL, 8, NULL);

DECLARE @admin_id BIGINT = (SELECT id FROM sys_menu WHERE label = 'Administration' AND parent_id IS NULL);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/admin/users')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Utilisateurs', '/admin/users', 1, @admin_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/admin/roles')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Rôles', '/admin/roles', 2, @admin_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/admin/menus')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Menus', '/admin/menus', 3, @admin_id);

IF NOT EXISTS (SELECT 1 FROM sys_menu WHERE route = '/admin/reference')
INSERT INTO sys_menu (label, route, ordre, parent_id)
VALUES ('Références', '/admin/reference', 4, @admin_id);


