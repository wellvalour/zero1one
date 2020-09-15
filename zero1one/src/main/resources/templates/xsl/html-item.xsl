<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema">

	<xsl:output method="html" encoding="UTF-8" />


	<xsl:template match="/">
		<html>
			<head>
				<link crossorigin="anonymous"
					integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
					href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
					rel="stylesheet" />

				<div class="container">
					<h2>
						<xsl:value-of select="CI-Typ" />
					</h2>
				</div>
			</head>
			<body>
				<div class="container">
					<table class="table table-striped table-dark">
						<thead>
							<tr>
								<th>Attribut</th>
								<th>Wert</th>
							</tr>
						</thead>
						p
						<tbody>
							<xsl:for-each select="/Attribut">
								<tr>
									<td>
										<xsl:value-of select="Name" />
									</td>
									<td>
										<xsl:value-of select="Wert" />
									</td>
								</tr>
							</xsl:for-each>
						</tbody>
					</table>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>