INSERT INTO `role` (`id`, `role_name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
	
INSERT INTO `type` (`id`, `type_name`, `abreviation`) VALUES
	(1, 'abréviation', 'abrév.'),
	(2, 'abstrait', 'abstr.'),
	(3, 'accusatif', 'acc.'),
	(4, 'adjectif', 'adj.'),
	(5, 'adverbe', 'adv.'),
	(6, 'affirmatif', 'affirm.'),
	(7, 'allemand', 'alld.'),
	(8, 'ancien', 'anc.'),
	(9, 'anglais', 'angl.'),
	(10, 'applicatif', 'appl.'),
	(11, 'après', 'apr.'),
	(12, 'archaïque', 'arch.'),
	(13, 'auxiliaire', 'aux.'),
	(14, 'avec', 'av.');
	
	
INSERT INTO `user` (`id`, `active`, `login`, `password`) VALUES
	(1, 1, 'admin', '1234'),
	(2, 1, 'ngando', '1234'),
	(3, 0, 'user', '1234');
	
INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES
	(1, 1),
	(1, 2),
	(2, 2),
	(3, 2);
	
INSERT INTO word (libelle, traduction) VALUES
('a', '<p>1) pronom personnel verbal 3e personne singulier, devant verbe avec consonne se rapporte &agrave; un singulier. (g. 1) ; dispara&icirc;t par contraction devant verbe avec voyelle : <strong>&nbsp;il, elle</strong> :<span style="color: #00ccff;">&nbsp;<em>a mabola&nbsp;</em><span style="color: #444444;">~</span><em>&nbsp;&nbsp;</em></span><span style="color: #000000;">il donne</span>; &nbsp;<span><em><span style="color: #00ccff;">s&aacute;ngo a mala</span></em></span>&nbsp;~&nbsp;le p&egrave;re (il) part; <span style="color: #00ccff;"><em>asumw</em>e̲</span>&nbsp;~&nbsp;il est parti.</p>\r\n<p>2) particule du g&eacute;nitif. d&eacute;pendant de noms singulier (g. 1, 4, 5, 7) et pluriel (g. 7);&nbsp;le <span style="color: #00ccff;"><em>a</em></span> est parfois &eacute;lid&eacute; : singulier (g. 1)<em><span><span style="color: #00ccff;">&nbsp;s</span></span></em><span style="color: #00ccff;"><em>&aacute;</em></span><em><span><span style="color: #00ccff;">ngo a m&uacute;na</span></span></em>&nbsp;~&nbsp;le p&egrave;re de l''enfant; &nbsp;singulier (g. 4): <span style="color: #00ccff;"><em>ebol'' a ndutu</em></span>&nbsp;~&nbsp;un travail difficile; singulier (g. 7) :&nbsp;<em><span style="color: #00ccff;">nge'' a pe&ntilde;a&nbsp;</span></em>~&nbsp;un nouveau chemin ; plur. g. 7 : <span style="color: #00ccff;"><em>ngo̲nded''a mundi</em></span>&nbsp;~&nbsp;les jeunes&nbsp;filles du village.</p>\r\n<p>3) particule de vocatif :&nbsp;<em><span style="color: #00ccff;">a s&aacute;ngo, &oacute;ngwan<span style="color: #444444;"><span style="color: #00ccff;">e̲</span>&nbsp;</span>mba !</span>&nbsp;</em>~&nbsp;ma&icirc;tre, aide-moi !</p>'),
('ā', '<p>1) interjection, exprimer un refus &eacute;nergique, le m&eacute;contentement (avec&nbsp;hochement de la t&ecirc;te) : <strong>non</strong>.</p>\r\n<p>2)&nbsp;<br />a) (peut-&ecirc;tre un parfait d''un verbe disparu) apr&egrave;s un nom singulier (g. 1) : <strong>&ecirc;tre&nbsp;d&eacute;j&agrave;</strong> : <em><span style="color: #00ccff;">mul<span style="font-size: 14px; text-align: -webkit-center;">ē</span>di&nbsp;<span style="font-size: 14px; text-align: -webkit-center;">ā</span><em>&nbsp;&oacute;&nbsp;esuk&uacute;lu</em></span></em>&nbsp;~&nbsp;l''instituteur est d&eacute;j&agrave; &agrave; l''&eacute;cole; <span style="color: #00ccff;"><em><span style="color: #00ccff;">n<span style="font-size: 14px; text-align: -webkit-center;">ā</span>&nbsp;mul<span style="font-size: 14px; text-align: -webkit-center;">ē</span>di</span>&nbsp;</em></span>~&nbsp;je suis d&eacute;j&agrave; instituteur</p>\r\n<p>b) suivi de <em><span style="color: #00ccff;">n<span style="font-size: 14px; text-align: -webkit-center;">&aacute;</span></span></em>&nbsp;avec subjonctif : <strong>&ecirc;tre d&eacute;j&agrave; en train de&nbsp;</strong>; <span style="color: #00ccff;"><em>s&aacute;ngo&nbsp;<span style="font-size: 14px; text-align: -webkit-center;">ā</span>&nbsp;te̲&nbsp;n&aacute; a&nbsp;bole ebolo, bi&ntilde;<span style="font-size: 14px; text-align: -webkit-center;">o̲</span><span style="color: #00ccff;">&nbsp;&oacute;ngwane̲&nbsp;mo̲&nbsp;!</span>&nbsp;</em></span>~ si le patron est d&eacute;j&agrave; en train de&nbsp;travailler, aidez-le !</p>'),
('aba, -i', '<p>passif <span style="color: #00ccff;"><em>ababe̲&nbsp;</em></span>: partager, s&eacute;parer, diviser, d&eacute;sunir; <span style="color: #00ccff;"><em>aba dib</em></span><span style="color: #00ccff;"><em>&aacute;</em></span>&nbsp;~&nbsp;rompre un mariage, divorcer</p>\r\n<p>voir : <em><span style="color: #00ccff;">abea - abane̲&nbsp;- jabea - jabane̲</span></em></p>'),
('aba !', '<p>interjection exprimant la surprise, le d&eacute;sespoir, la douleur : <strong>oh !</strong></p>'),
('ába, -i', '<p>passif : <em><span style="color: #00ccff;">&aacute;babe̲</span><span style="color: #00ccff;">&nbsp;</span></em><strong>lamper</strong> : <em><span style="color: #00ccff;">&nbsp;bato b&aacute;bi nd&oacute;ng&oacute;&nbsp;&ntilde;</span></em><span style="color: #00ccff;">&eacute;̲</span><em><span style="color: #00ccff;">se̲&nbsp;ni ta&nbsp;&oacute;&nbsp;mo̲njo̲</span></em>&nbsp;~&nbsp;ils ont lamp&eacute; toute la soupe qui &eacute;tait dans l''assiette .</p>');
