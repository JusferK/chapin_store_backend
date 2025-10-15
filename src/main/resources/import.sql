--------------------------------------------------------------------------------------------------------------------------------  CATEGORIAS ---------------------------------------------------------------------

INSERT INTO Category (name, description) VALUES ('Electrónicos', 'Gadgets, dispositivos multiuso, entre otros.');
INSERT INTO Category (name, description) VALUES ('Ropa', 'Prendas de vestir para hombre, mujer y niños.');
INSERT INTO Category (name, description) VALUES ('Hogar', 'Artículos para el hogar y la decoración.');
INSERT INTO Category (name, description) VALUES ('Deportes', 'Equipos, accesorios y ropa deportiva.');
INSERT INTO Category (name, description) VALUES ('Juguetes', 'Juguetes y juegos educativos para todas las edades.');
INSERT INTO Category (name, description) VALUES ('Libros', 'Literatura, textos académicos y material de consulta.');
INSERT INTO Category (name, description) VALUES ('Belleza', 'Cosméticos, perfumes y productos para el cuidado personal.');
INSERT INTO Category (name, description) VALUES ('Mascotas', 'Accesorios, alimentos y juguetes para mascotas.');
INSERT INTO Category (name, description) VALUES ('Automotriz', 'Repuestos, herramientas y accesorios para vehículos.');
INSERT INTO Category (name, description) VALUES ('Tecnología', 'Software, servicios en la nube y accesorios digitales.');


--------------------------------------------------------------------------------------------------------------------------------  PRODUCTOS ---------------------------------------------------------------------

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Smartphone Galaxy X', 'Teléfono inteligente con cámara de 108MP y batería de larga duración', 750, 50, 'https://m.media-amazon.com/images/I/61pMFRAs+3L._AC_SX679_.jpg', 1);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES  ('Playera de The boys', 'Playera de verano con estampado de The Boys en diferentes tamaños', 20, 120, 'https://srv.latostadora.com/image/the-boys-club--id:cdd60890-3b3f-4b4e-9b16-03209b14dc47;s:H_A1;b:f2f2f2;w:520;f:f;i:135623135623201709261.jpg', 2);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Sofá Reclinable', 'Sofá de tres plazas en tela gris, reclinable con portavasos', 480, 15, 'https://imgs.search.brave.com/bxstF8d22_vTPE-Hfj-TzmHHxiXrQCkq_H8pZONjJfg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/cm9zZW4uY2wvbWVk/aWEvY2F0YWxvZy9w/cm9kdWN0LzEvMy8x/MzAxNzgwMC01bS5q/cGc_cXVhbGl0eT0x/MDAmYmctY29sb3I9/MjU1LDI1NSwyNTUm/Zml0PWJvdW5kcyZo/ZWlnaHQ9NDAwJndp/ZHRoPTQwMCZjYW52/YXM9NDAwOjQwMA', 3);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Balón de Fútbol Adidas', 'Balón oficial de la liga con diseño resistente y duradero', 35, 200, 'https://imgs.search.brave.com/ojfmcZhVep4OcIlrtXjj4VSzL27ZSWU04Unx1WJmzyY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/XzY5Nzc4Ni1NTFY4/NjA1MjcyODU5OV8w/NjIwMjUtVi53ZWJw', 4);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Lego Star Wars', 'Set de construcción con 500 piezas de la saga Star Wars', 90, 60, 'https://imgs.search.brave.com/zGHm16Ab1WGYXpQCdWFbh9MqyDtzUtQbtu4wOLyhdD4/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMudGhjZG4uY29t/L2ltYWdlcy94c21h/bGwvb3JpZ2luYWwv/L3Byb2R1Y3RpbWcv/b3JpZ2luYWwvMTM2/MzQyOTctMjAyNDkz/MDg2NTU3NzM4NC5q/cGc', 5);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Libro: Cien Años de Soledad', 'Edición especial con portada dura del clásico de Gabriel García Márquez', 18, 85, 'https://imgs.search.brave.com/d3DsoR3X6oZ3EKkuPC1TllbktmvbLPDh1kgkN9XLiOw/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuY2RuMy5idXNj/YWxpYnJlLmNvbS9m/aXQtaW4vMzYweDM2/MC8yZC8xNi8yZDE2/MWIzMjEyZDMxZWVh/YTE2NDJlZTlkMmE1/MDMzYi5qcGc', 6);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Perfume Chanel No. 5', 'Perfume clásico de mujer en presentación de 100ml', 110, 40, 'https://imgs.search.brave.com/h65-5jaNWhBDugV5SosZCuWjERuFiPn8d7QxkmAwdbE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2hhbmVsLmNvbS9p/bWFnZXMvdF9vbmUv/L3dfMC41MSxoXzAu/NTEsY19jcm9wL3Ff/YXV0bzpnb29kLGZf/YXV0byxmbF9sb3Nz/eSxkcHJfMS4xL3df/MTkyMC8vbi01LWxp/bWl0ZWQtZWRpdGlv/bi1lYXUtZGUtcGFy/ZnVtLXNwcmF5LTMt/NGZsLW96LS1wYWNr/c2hvdC1kZWZhdWx0/LTEyNTQ3Ny05NTQ5/NTM0ODU1MTk4Lmpw/Zw', 7);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Collar para Perros', 'Collar ajustable de cuero con hebilla metálica', 15, 150, 'https://imgs.search.brave.com/DZUQ7qVHWL9D0qTujjFPIdnF4Ke1EwvyMvnrCjiLBZQ/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMtbmEuc3NsLWlt/YWdlcy1hbWF6b24u/Y29tL2ltYWdlcy9J/LzcxTndtcWRRTDlM/LmpwZw', 8);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Llantas Michelin 15"', 'Juego de 4 llantas para automóvil de uso urbano', 320, 25, 'https://imgs.search.brave.com/16YSoojGISMgp0VT9jEr8BomnyYwfOdTsD0LIyPZtNQ/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/Xzg1NTY5My1NTFU3/NTEwMzg3NDY1NF8w/MzIwMjQtVi53ZWJw', 9);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Teclado Mecánico RGB', 'Teclado gamer con luces RGB y switches azules', 65, 70, 'https://m.media-amazon.com/images/I/61Tn5a431IL._AC_SX679_.jpg', 10);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Laptop Lenovo ThinkPad', 'Laptop de 14" con procesador i7 y 16GB RAM', 950, 30, 'https://cdn.mos.cms.futurecdn.net/5zZbN9eDoohNs4poBygeh4.png', 1);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Jeans Levis 501', 'Jeans azul clásico para hombre, todas las tallas', 45, 200, 'https://lsco.scene7.com/is/image/lsco/A19590033-front-pdp?fmt=webp&qlt=70&resMode=sharp2&fit=crop,1&op_usm=0.6,0.6,8&wid=880&hei=880', 2);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Mesa de Centro Moderna', 'Mesa de madera con acabado minimalista', 120, 40, 'https://imgs.search.brave.com/3llCukbIvcoS32giUbQg1epmMC8c6WxBxAJ6Bjq7MOA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/Xzk4MzI2My1NTE05/MDkyMzk4MzI3NF8w/ODIwMjUtRS1tZXNh/LWRlLWNlbnRyby1t/b2Rlcm5hLWRlLW1h/ZGVyYS1wYXJhLXNh/bGEtbWluaW1hbGlz/dGEud2VicA', 3);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Raqueta de Tenis Wilson', 'Raqueta profesional de grafito con funda', 130, 60, 'https://imgs.search.brave.com/U2Ont4ma7OJcWVMp2fxwL0LxTvexcbtLbDaIicYEgXI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/Xzk1NzA1Mi1NTEM3/OTYzNzQxMjc4Nl8x/MDIwMjQtRS1yYXF1/ZXRhLWRlLXRlbmlz/LXdpbHNvbi11bHRy/YS1wb3dlci1yeHQt/MTA1LXJlY3JlYXRp/dm8ud2VicA', 4);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Muñeca Barbie', 'Barbie fashionista edición especial 2025', 30, 150, 'https://imgs.search.brave.com/svAPIwUFaf7RJaVRmfPCE9weogu3wSXetLBrY18wl6U/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/XzY2NDkyOS1NTEE4/MTg1Mjg0ODQwOF8w/MTIwMjUtRS53ZWJw', 5);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Libro: El Señor de los Anillos', 'Trilogía completa en un solo tomo ilustrado', 50, 90, 'https://imgs.search.brave.com/QoG7OJEMzMKQgKGc18rpXLkV7kWkcb9qaIXRF-MqSi0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/Xzg5ODIyOC1NTE01/MDIxMzU2NzYxOV8w/NjIwMjItVi1saWJy/by1lbC1zZW5vci1k/ZS1sb3MtYW5pbGxv/cy1hbGFuLWxlZS1v/cmlnaW5hbC53ZWJw', 6);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Labial MAC Mate', 'Labial de larga duración color rojo pasión', 25, 110, 'https://imgs.search.brave.com/Gn_3mJUnR6p5VEbAC6z5_8pUhaEGV8P2A_DudoWPZ0w/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9odHRw/Mi5tbHN0YXRpYy5j/b20vRF9RX05QXzJY/Xzg3OTUwOS1NTFU3/NDg5OTM0MTY4MF8w/MzIwMjQtRS53ZWJw', 7);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Cama para Gatos', 'Cama acolchada en forma de iglú para gatos pequeños', 35, 95, 'https://imgs.search.brave.com/oQ51bj5AxfiG7OCRA1bSoB0-MnyFC8Q7QchXnzOAq2o/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9raXpl/dGFzdG9yZS5jb20v/Y2RuL3Nob3AvZmls/ZXMvMl9iNDUyZWQ0/Ni1hYWQ2LTRiODIt/OTA4NS0xNTcyZTJh/NTc2NmUucG5nP3Y9/MTcyMjY0ODc1MiZ3/aWR0aD0xMDgw', 8);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ('Aceite de Motor Castrol', 'Aceite sintético para motor de 5L', 42, 80, 'https://imgs.search.brave.com/CfDn3p9kTdfF3qOfJe3j4WVGc3_MKkQIpDXwtMLPlAE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/bW90b3JlY2FtYmlv/c3ZmZXJyZXIuZXMv/MTI1NzE3LWhvbWVf/ZGVmYXVsdC9hY2Vp/dGUtY2FzdHJvbC1t/b3RvLXBvd2VyLTEt/c2Nvb3Rlci00dC01/dzQwLTEtbGl0cm8u/anBn', 9);

INSERT INTO Product (name, description, price, stock, image, category_id) VALUES ( 'Mouse Inalámbrico Logitech', 'Mouse ergonómico con batería recargable y conexión bluetooth', 28, 130, 'https://imgs.search.brave.com/cs7sQi0gI56XkcKFbsrNZzsXxkJpYRetZNf4TdZQpls/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/b2ZmaWNlZGVwb3Qu/Y29tLm14L21lZGlh/cy8xMDAwMDU2MzQu/anBnLTMwMGZ0dz9j/b250ZXh0PWJXRnpk/R1Z5ZkhKdmIzUjhN/ak0wT1RsOGFXMWha/MlV2YW5CbFozeGhS/R00wVERKbk0wNTVP/SGhOUkVGM1RsUkZN/VTE2VVRCT2Vtc3lU/bWsxY1dOSFkzdzBZ/Mkl4WVRBMk1XVmpZ/akV6TkRJNFlUVTJP/VE13WVRRMU16YzBa/amsyTWpNNVlXUmlO/R05qTm1Zd1lqWTRO/R1ExWkRSbU1qQmlO/R1EwTmpVMk5tTmg', 10);

--------------------------------------------------------------------------------------------------------------------------------  MODULO ---------------------------------------------------------------------------------

INSERT INTO Module (id, name, base_path, active) values (1, 'productos','/product', true);
INSERT INTO Module (id, name, base_path, active) values (2, 'pagos','/payment', true);
INSERT INTO Module (id, name, base_path, active) values (3, 'ordenes','/order-request', true);
INSERT INTO Module (id, name, base_path, active) values (4, 'detalle','/detail', true);
INSERT INTO Module (id, name, base_path, active) values (5, 'clientes', '/customer', true);
INSERT INTO Module (id, name, base_path, active) values (6, 'direcciones', '/address', true);
INSERT INTO Module (id, name, base_path, active) values (7, 'categorias', '/category', true);
INSERT INTO Module (id, name, base_path, active) values (8, 'administradores', '/administrator', true);
INSERT INTO Module (id, name, base_path, active) values (9, 'autenticacion', '/auth', true);
INSERT INTO Module (id, name, base_path, active) values (10, 'role', '/role', true);
INSERT INTO Module (id, name, base_path, active) values (11, 'operaciones', '/operation', true);
INSERT INTO Module (id, name, base_path, active) values (12, 'modulos', '/module', true);
INSERT INTO Module (id, name, base_path, active) values (13, 'permisos', '/permission', true);
INSERT INTO Module (id, name, base_path, active) values (14, 'menus', '/menu', true);

--------------------------------------------------------------------------------------------------------------------------------  OPERACION ---------------------------------------------------------------------------------

-- PRODUCTOS
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (1, 'READ_ALL_PRODUCTS', '/get-all', 'GET', 1, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (2, 'READ_ALL_PRODUCTS_BY_CATEGORY', '/get-all-by-category', 'GET', 1, true, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (3, 'READ_ONE_PRODUCT', '/get', 'GET', 1, true, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (4, 'CREATE_PRODUCT', '/new', 'POST', 1, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (5, 'PATCH_PRODUCT', '/patch', 'PATCH', 1, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (6, 'DELETE_PRODUCT', '/delete', 'DELETE', 1, false, true);

-- PAGOS
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (7, 'CREATE_PAYMENT', '/new', 'POST', 2, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (8, 'READ_ALL_OWN_PAYMENT', '/find', 'GET', 2, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (9, 'DELETE_PAYMENT', '/delete', 'DELETE', 2, false, true);

-- ORDENES
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (10, 'READ_ALL_ORDERS', '/get-all', 'GET', 3, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (11, 'READ_ALL_OWN_ORDERS', '/get', 'GET', 3, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (12, 'CREATE_ORDER', '/new', 'POST', 3, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (13, 'PATCH_ORDER', '/patch', 'PATCH', 3, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (14, 'PATCH_ORDER_STATUS', '/update/status', 'PATCH', 3, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (15, 'DELETE_ORDER', '/delete', 'DELETE', 3, false, true);

-- DETALLE
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (16, 'PATCH_DETAIL_QUANTITY', '/patch/quantity', 'PATCH', 4, false, true);

-- CLIENTE
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (17, 'READ_ALL_CUSTOMERS', '/get-all', 'GET', 5, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (18, 'READ_ONE_CUSTOMER', '/get', 'GET', 5, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (19, 'CREATE_CUSTOMER', '/register', 'POST', 5, true, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (20, 'PATCH_CUSTOMER', '/patch', 'PATCH', 5, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (21, 'DELETE_CUSTOMER', '/disable/[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}', 'DELETE', 5, false, true);

-- DIRECCIONES
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (22, 'CREATE_ADDRESS', '/new', 'POST', 6, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (23, 'READ_ALL_OWN_ADDRESS', '/get', 'GET', 6, false, true);

-- CATEGORIAS
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (24, 'READ_ALL_CATEGORIES', '/get-all', 'GET', 7, true, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (25, 'CREATE_CATEGORY', '/new', 'POST', 7, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (26, 'PATCH_CATEGORY', '/patch', 'PATCH', 7, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (27, 'DELETE_CATEGORY', '/delete', 'DELETE', 7, false, true);

-- ADMINISTRATOR
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (28, 'READ_ALL_ADMINISTRATORS', '/get-all', 'GET', 8, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (29, 'READ_ONE_ADMINISTRATOR', '/get', 'GET', 8, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (30, 'CREATE_ADMINISTRATOR', '/register', 'POST', 8, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (31, 'PATCH_ADMINISTRATOR_PASSWORD', '/patch/password', 'PATCH', 8, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (32, 'DELETE_ADMINISTRATOR', '/disable', 'DELETE', 8, false, true);

-- AUTHENTICATE
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (33, 'LOGIN', '/login', 'POST', 9, true, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (34, 'LOGOUT', '/logout', 'POST', 9, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (53, 'VALIDATE', '/validate', 'GET', 9, false, true);

-- ROLE
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (35, 'CREATE_ROLE', '/new', 'POST', 10, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (36, 'READ_ALL_ROLES', '/get-all', 'GET', 10, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (37, 'DELETE_ROLE', '/disable', 'DELETE', 10, false, true);

-- OPERACIONES
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (38, 'CREATE_OPERATION', '/new', 'POST', 11, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (39, 'READ_ALL_OPERATIONS', '/get-all', 'GET', 11, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (40, 'PATCH_OPERATION', '/patch', 'PATCH', 11, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (41, 'DELETE_OPERATION', '/disable', 'DELETE', 11, false, true);

--MODULES
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (42, 'CREATE_MODULE', '/new', 'POST', 12, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (43, 'READ_ALL_MODULES', '/get-all', 'GET', 12, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (44, 'PATCH_MODULE', '/patch', 'PATCH', 12, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (45, 'DELETE_MODULE', '/disable', 'DELETE', 12, false, true);

--GRANTED PERMISSIONS
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (46, 'CREATE_GRANTED_PERMISSIONS', '/new', 'POST', 13, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (47, 'DELETE_GRANTED_PERMISSION', '/delete', 'DELETE', 13, false, true);

--MENU OPERATION

INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (48, 'CREATE_MENU', '/new', 'POST', 14, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (49, 'GET_ALL_MENUS', '/get-all', 'GET', 14, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (50, 'GET_MENUS_BY_ROL', '/get-by-role', 'GET', 14, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (51, 'PATCH_MENU', '/patch', 'PATCH', 14, false, true);
INSERT INTO Operation (id, name, path, method, module_id, permit_all, is_active) values (52, 'DELETE_MENU', '/delete', 'DELETE', 14, false, true);

--------------------------------------------------------------------------------------------------------------------------------  ROLES ---------------------------------------------------------------------------------

INSERT INTO Role (id, name, active) values (1, 'ADMINISTRATOR', true);
INSERT INTO Role (id, name, active) values (2, 'MANAGER', true);
INSERT INTO Role (id, name, active) values (3, 'CUSTOMER', true);

--------------------------------------------------------------------------------------------------------------------------------  GRANTED PERMISSIONS ---------------------------------------------------------------------------------

-------------------------------------------------------------------------------------------- ADMINISTRATOR PERMISSIONS

-- /PRODUCTOS
INSERT INTO granted_permission (id, role_id, operation_id) values (1, 1, 1);
INSERT INTO granted_permission (id, role_id, operation_id) values (2, 1, 2);
INSERT INTO granted_permission (id, role_id, operation_id) values (3, 1, 3);
INSERT INTO granted_permission (id, role_id, operation_id) values (4, 1, 4);
INSERT INTO granted_permission (id, role_id, operation_id) values (5, 1, 5);
INSERT INTO granted_permission (id, role_id, operation_id) values (6, 1, 6);

-- /ORDENES
INSERT INTO granted_permission (id, role_id, operation_id) values (7, 1, 10);
INSERT INTO granted_permission (id, role_id, operation_id) values (8, 1, 11);
INSERT INTO granted_permission (id, role_id, operation_id) values (9, 1, 14);
INSERT INTO granted_permission (id, role_id, operation_id) values (10, 1, 15);

-- /DETALLE
INSERT INTO granted_permission (id, role_id, operation_id) values (11, 1, 16);

-- /CLIENTE
INSERT INTO granted_permission (id, role_id, operation_id) values (12, 1, 17);
INSERT INTO granted_permission (id, role_id, operation_id) values (13, 1, 18);
INSERT INTO granted_permission (id, role_id, operation_id) values (14, 1, 21);

-- /DIRECCIONES
INSERT INTO granted_permission (id, role_id, operation_id) values (15, 1, 23);

-- /CATEGRIAS
INSERT INTO granted_permission (id, role_id, operation_id) values (16, 1, 24);
INSERT INTO granted_permission (id, role_id, operation_id) values (17, 1, 25);
INSERT INTO granted_permission (id, role_id, operation_id) values (18, 1, 26);
INSERT INTO granted_permission (id, role_id, operation_id) values (19, 1, 27);

-- /ADMINISTRATOR
INSERT INTO granted_permission (id, role_id, operation_id) values (20, 1, 28);
INSERT INTO granted_permission (id, role_id, operation_id) values (21, 1, 29);
INSERT INTO granted_permission (id, role_id, operation_id) values (22, 1, 30);
INSERT INTO granted_permission (id, role_id, operation_id) values (23, 1, 31);
INSERT INTO granted_permission (id, role_id, operation_id) values (24, 1, 32);

-- /AUTENTICACION
INSERT INTO granted_permission (id, role_id, operation_id) values (25, 1, 34);
INSERT INTO granted_permission (id, role_id, operation_id) values (74, 1, 53);

-- /ROLE
INSERT INTO granted_permission (id, role_id, operation_id) values (26, 1, 35);
INSERT INTO granted_permission (id, role_id, operation_id) values (27, 1, 36);
INSERT INTO granted_permission (id, role_id, operation_id) values (28, 1, 37);

-- /OPERACIONES
INSERT INTO granted_permission (id, role_id, operation_id) values (29, 1, 38);
INSERT INTO granted_permission (id, role_id, operation_id) values (30, 1, 39);
INSERT INTO granted_permission (id, role_id, operation_id) values (31, 1, 40);
INSERT INTO granted_permission (id, role_id, operation_id) values (32, 1, 41);

-- /MODULES
INSERT INTO granted_permission (id, role_id, operation_id) values (33, 1, 42);
INSERT INTO granted_permission (id, role_id, operation_id) values (34, 1, 43);
INSERT INTO granted_permission (id, role_id, operation_id) values (35, 1, 44);
INSERT INTO granted_permission (id, role_id, operation_id) values (36, 1, 45);

-- /GRANTED PERMISSIONS
INSERT INTO granted_permission (id, role_id, operation_id) values (37, 1, 46);
INSERT INTO granted_permission (id, role_id, operation_id) values (38, 1, 47);

--MENU OPERATION

INSERT INTO granted_permission (id, role_id, operation_id) values (39, 1, 48);
INSERT INTO granted_permission (id, role_id, operation_id) values (40, 1, 49);
INSERT INTO granted_permission (id, role_id, operation_id) values (41, 1, 50);
INSERT INTO granted_permission (id, role_id, operation_id) values (42, 1, 51);
INSERT INTO granted_permission (id, role_id, operation_id) values (43, 1, 52);


-------------------------------------------------------------------------------------------- MANAGER PERMISSIONS

-- /PRODUCTOS
INSERT INTO granted_permission (id, role_id, operation_id) values (44, 2, 1);
INSERT INTO granted_permission (id, role_id, operation_id) values (46, 2, 3);
INSERT INTO granted_permission (id, role_id, operation_id) values (47, 2, 4);
INSERT INTO granted_permission (id, role_id, operation_id) values (48, 2, 5);

-- /ORDENES
INSERT INTO granted_permission (id, role_id, operation_id) values (49, 2, 10);
INSERT INTO granted_permission (id, role_id, operation_id) values (50, 2, 11);
INSERT INTO granted_permission (id, role_id, operation_id) values (51, 2, 14);
INSERT INTO granted_permission (id, role_id, operation_id) values (52, 2, 15);

-- /DETALLE
INSERT INTO granted_permission (id, role_id, operation_id) values (53, 2, 16);

-- /CLIENTE
INSERT INTO granted_permission (id, role_id, operation_id) values (54, 2, 17);
INSERT INTO granted_permission (id, role_id, operation_id) values (55, 2, 18);
INSERT INTO granted_permission (id, role_id, operation_id) values (56, 2, 21);

-- /CATEGORIAS
INSERT INTO granted_permission (id, role_id, operation_id) values (57, 2, 25);
INSERT INTO granted_permission (id, role_id, operation_id) values (58, 2, 26);
INSERT INTO granted_permission (id, role_id, operation_id) values (59, 2, 27);

-- /AUTENTICACION
INSERT INTO granted_permission (id, role_id, operation_id) values (60, 2, 34);

-- /MENU

INSERT INTO granted_permission (id, role_id, operation_id) values (61, 2, 50);

-------------------------------------------------------------------------------------------- CUSTOMER

-- /PAGOS
INSERT INTO granted_permission (id, role_id, operation_id) values (62, 3, 7);
INSERT INTO granted_permission (id, role_id, operation_id) values (63, 3, 8);
INSERT INTO granted_permission (id, role_id, operation_id) values (64, 3, 9);

-- /ORDENES
INSERT INTO granted_permission (id, role_id, operation_id) values (65, 3, 11);
INSERT INTO granted_permission (id, role_id, operation_id) values (66, 3, 12);
INSERT INTO granted_permission (id, role_id, operation_id) values (67, 3, 13);
INSERT INTO granted_permission (id, role_id, operation_id) values (68, 3, 14);
INSERT INTO granted_permission (id, role_id, operation_id) values (69, 3, 15);

-- /DETAIL
INSERT INTO granted_permission (id, role_id, operation_id) values (70, 3, 16);

-- /DIRECCIONES
INSERT INTO granted_permission (id, role_id, operation_id) values (71, 3, 22);
INSERT INTO granted_permission (id, role_id, operation_id) values (72, 3, 23);

-- /AUTENTICACION
INSERT INTO granted_permission (id, role_id, operation_id) values (73, 3, 34);

--------------------------------------------------------------------------------------------------------------------------------  MENUS ---------------------------------------------------------------------

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (1, 'Productos', 'pi pi-shop', null, '/product', true);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (2, 'Agregar producto', 'pi pi-plus', 1, '/product/add', false);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (4, 'Seguridad', 'pi pi-shield', null, '/security', true);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (5, 'Permisos', 'pi pi-shield', 4, '/security/permission', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (6, 'Eliminar', 'pi pi-trash', 5, '/security/permission/delete', false);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (7, 'Modulos', 'pi pi-list', 4, '/security/modules', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (8, 'Agregar modulo', 'pi pi-plus', 7, '/security/modules/add', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (9, 'Editar modulo', 'pi pi-pencil', 7, '/security/modules/edit', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (10, 'Deshabilitar modulo', 'pi pi-power-off', 7, '/security/modules/disable', false);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (11, 'Operaciones', 'pi pi-warehouse', 4, '/security/operations', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (12, 'Agregar operacion', 'pi pi-plus', 11, '/security/operations/add', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (13, 'Editar operacion', 'pi pi-pencil', 11, '/security/operations/edit', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (14, 'Deshabilitar operacion', 'pi pi-power-off', 11, '/security/operations/disable', false);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (15, 'Administradores', 'pi pi-users', null, '/administrator', true);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (16, 'Agregar administrador', 'pi pi-user-plus', 15, '/administrator/add', false);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (17, 'Ordenes', 'pi pi-cart-plus', null, '/orders', true);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (18, 'Usuarios', 'pi pi-user', null, '/users', true);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (19, 'Categorias', 'pi pi-bars', null, '/categories', true);

INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (22, 'Roles', 'pi pi-id-card', 4, '/security/roles', false);
INSERT INTO menu_operation (id, label, icon, father_id, router_link, is_father) values (23, 'Agregar rol', 'pi pi-plus', 22, '/security/roles/add', false);

--------------------------------------------------------------------------------------------------------------------------------  Role : Menu ---------------------------------------------------------------------

-------------------------------------------------------------------------------------------- ADMINISTRATOR MENU PERMISSIONS

INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (1, 1, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (2, 2, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (4, 4, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (5, 5, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (6, 6, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (7, 7, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (8, 8, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (9, 9, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (10, 10, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (11, 11, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (12, 12, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (13, 13, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (14, 14, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (15, 15, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (16, 16, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (17, 17, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (18, 18, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (19, 19, 1);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (22, 22, 1);

-------------------------------------------------------------------------------------------- MANAGER MENU PERMISSIONS

INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (23, 1, 2);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (24, 17, 2);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (25, 18, 2);
INSERT INTO role_menu (id, menu_operation_id, role_id) VALUES (26, 19, 2);

--------------------------------------------------------------------------------------------------------------------------------  ADMIN ---------------------------------------------------------------------


INSERT INTO Administrator (username, password, is_active, role_id) values ('admin', '$2a$10$uGoUPehLPp9ozpDUqTMCXOt0nbGw3qFVIGXAndJ2BeoO0Rtua9IDW', true,1);