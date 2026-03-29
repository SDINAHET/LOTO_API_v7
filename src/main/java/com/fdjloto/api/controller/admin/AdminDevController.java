// // // // // // // // package com.fdjloto.api.controller.admin;

// // // // // // // // import org.springframework.core.io.Resource;
// // // // // // // // import org.springframework.core.io.UrlResource;
// // // // // // // // import org.springframework.http.ResponseEntity;
// // // // // // // // import org.springframework.security.access.prepost.PreAuthorize;
// // // // // // // // import org.springframework.web.bind.annotation.*;

// // // // // // // // import java.io.IOException;
// // // // // // // // import java.nio.file.*;

// // // // // // // // @RestController
// // // // // // // // @RequestMapping("/api/admin/dev")
// // // // // // // // public class AdminDevController {

// // // // // // // //     @GetMapping("/coverage")
// // // // // // // //     @PreAuthorize("hasRole('ADMIN')")
// // // // // // // //     public ResponseEntity<Resource> getCoverage() throws IOException {

// // // // // // // //         Path file = Paths.get("target/site/jacoco/index.html");

// // // // // // // //         if (!Files.exists(file)) {
// // // // // // // //             return ResponseEntity.notFound().build();
// // // // // // // //         }

// // // // // // // //         Resource resource = new UrlResource(file.toUri());

// // // // // // // //         return ResponseEntity.ok()
// // // // // // // //                 .header("Content-Type", "text/html")
// // // // // // // //                 .body(resource);
// // // // // // // //     }
// // // // // // // // }


// // // // // // // package com.fdjloto.api.controller.admin;

// // // // // // // import org.springframework.core.io.Resource;
// // // // // // // import org.springframework.core.io.UrlResource;
// // // // // // // import org.springframework.http.MediaType;
// // // // // // // import org.springframework.http.ResponseEntity;
// // // // // // // import org.springframework.security.access.prepost.PreAuthorize;
// // // // // // // import org.springframework.web.bind.annotation.*;

// // // // // // // import java.io.IOException;
// // // // // // // import java.nio.file.*;
// // // // // // // import java.util.Map;

// // // // // // // @RestController
// // // // // // // @RequestMapping("/api/admin/dev")
// // // // // // // public class AdminDevController {

// // // // // // //     @GetMapping("/coverage")
// // // // // // //     @PreAuthorize("hasRole('ADMIN')")
// // // // // // //     public ResponseEntity<Resource> getCoverage() throws IOException {

// // // // // // //         // 🔥 FIX PRO : chemin absolu basé sur le projet
// // // // // // //         Path file = Paths.get(System.getProperty("user.dir"))
// // // // // // //                 .resolve("target/site/jacoco/index.html")
// // // // // // //                 .normalize();

// // // // // // //         // 🔎 DEBUG (optionnel mais utile)
// // // // // // //         System.out.println("📊 JaCoCo path: " + file.toAbsolutePath());
// // // // // // //         System.out.println("📊 Exists: " + Files.exists(file));

// // // // // // //         if (!Files.exists(file)) {
// // // // // // //             return ResponseEntity.notFound().build();
// // // // // // //         }

// // // // // // //         Resource resource = new UrlResource(file.toUri());

// // // // // // //         return ResponseEntity.ok()
// // // // // // //                 .contentType(MediaType.TEXT_HTML)
// // // // // // //                 .body(resource);
// // // // // // //     }

// // // // // // // 	@GetMapping("/coverage/summary")
// // // // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // // // 	public Map<String, Object> getCoverageSummary() throws IOException {

// // // // // // // 		Path file = Paths.get(System.getProperty("user.dir"))
// // // // // // // 				.resolve("target/site/jacoco/index.html");

// // // // // // // 		String content = Files.readString(file);

// // // // // // // 		// extraction simple %
// // // // // // // 		int index = content.indexOf("Total");
// // // // // // // 		String snippet = content.substring(index, index + 200);

// // // // // // // 		return Map.of(
// // // // // // // 				"coverage", snippet
// // // // // // // 		);
// // // // // // // 	}

// // // // // // // }

// // // // // // package com.fdjloto.api.controller.admin;

// // // // // // import org.springframework.core.io.Resource;
// // // // // // import org.springframework.core.io.UrlResource;
// // // // // // import org.springframework.http.MediaType;
// // // // // // import org.springframework.http.ResponseEntity;
// // // // // // import org.springframework.security.access.prepost.PreAuthorize;
// // // // // // import org.springframework.web.bind.annotation.*;

// // // // // // import java.io.IOException;
// // // // // // import java.nio.file.*;
// // // // // // import java.util.Map;

// // // // // // import jakarta.servlet.http.HttpServletRequest;

// // // // // // @RestController
// // // // // // @RequestMapping("/api/admin/dev")
// // // // // // public class AdminDevController {

// // // // // //     // @GetMapping("/coverage")
// // // // // //     // @PreAuthorize("hasRole('ADMIN')")
// // // // // //     // public ResponseEntity<Resource> getCoverage() throws IOException {

// // // // // //     //     Path file = Paths.get(System.getProperty("user.dir"))
// // // // // //     //             .resolve("target/site/jacoco/index.html")
// // // // // //     //             .normalize();

// // // // // //     //     System.out.println("📊 JaCoCo path: " + file.toAbsolutePath());
// // // // // //     //     System.out.println("📊 Exists: " + Files.exists(file));

// // // // // //     //     if (!Files.exists(file)) {
// // // // // //     //         return ResponseEntity.notFound().build();
// // // // // //     //     }

// // // // // //     //     Resource resource = new UrlResource(file.toUri());

// // // // // //     //     return ResponseEntity.ok()
// // // // // //     //             .contentType(MediaType.TEXT_HTML)
// // // // // //     //             .body(resource);
// // // // // //     // }

// // // // // // 	@GetMapping("/coverage")
// // // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // // 	public ResponseEntity<String> getCoverage() throws IOException {

// // // // // // 		Path file = Paths.get(System.getProperty("user.dir"))
// // // // // // 				.resolve("target/site/jacoco/index.html")
// // // // // // 				.normalize();

// // // // // // 		if (!Files.exists(file)) {
// // // // // // 			return ResponseEntity.notFound().build();
// // // // // // 		}

// // // // // // 		String html = Files.readString(file);

// // // // // // 		// 🔥 injection CSS custom
// // // // // // 		String css = """
// // // // // // 			<style>
// // // // // // 				body {
// // // // // // 					background:#0b1220;
// // // // // // 					color:#e5e7eb;
// // // // // // 					font-family:Arial;
// // // // // // 				}
// // // // // // 				table {
// // // // // // 					background:#111827;
// // // // // // 					border-radius:10px;
// // // // // // 					overflow:hidden;
// // // // // // 				}
// // // // // // 				th {
// // // // // // 					background:#1f2937;
// // // // // // 					color:#9ca3af;
// // // // // // 				}
// // // // // // 				tr:hover {
// // // // // // 					background:rgba(59,130,246,0.1);
// // // // // // 				}
// // // // // // 				a {
// // // // // // 					color:#60a5fa;
// // // // // // 				}
// // // // // // 			</style>
// // // // // // 		""";

// // // // // // 		html = html.replace("</head>", css + "</head>");

// // // // // // 		return ResponseEntity.ok()
// // // // // // 				.contentType(MediaType.TEXT_HTML)
// // // // // // 				.body(html);
// // // // // // 	}

// // // // // //     // 🔥 VERSION SAFE + ROBUSTE
// // // // // //     @GetMapping("/coverage/summary")
// // // // // //     @PreAuthorize("hasRole('ADMIN')")
// // // // // //     public Map<String, Object> getCoverageSummary() {

// // // // // //         try {
// // // // // //             Path file = Paths.get(System.getProperty("user.dir"))
// // // // // //                     .resolve("target/site/jacoco/index.html");

// // // // // //             if (!Files.exists(file)) {
// // // // // //                 return Map.of(
// // // // // //                         "coverage", "N/A",
// // // // // //                         "error", "JaCoCo report not found"
// // // // // //                 );
// // // // // //             }

// // // // // //             String content = Files.readString(file);

// // // // // //             int index = content.indexOf("Total");

// // // // // //             if (index == -1) {
// // // // // //                 return Map.of(
// // // // // //                         "coverage", "N/A",
// // // // // //                         "error", "Coverage not found in report"
// // // // // //                 );
// // // // // //             }

// // // // // //             int end = Math.min(index + 200, content.length());

// // // // // //             String snippet = content.substring(index, end);

// // // // // //             return Map.of(
// // // // // //                     "coverage", snippet
// // // // // //             );

// // // // // //         } catch (Exception e) {

// // // // // //             return Map.of(
// // // // // //                     "coverage", "N/A",
// // // // // //                     "error", e.getMessage()
// // // // // //             );
// // // // // //         }
// // // // // //     }

// // // // // // 	@GetMapping("/coverage/files/**")
// // // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // // 	public ResponseEntity<Resource> getCoverageFiles(HttpServletRequest request) throws IOException {

// // // // // // 		String uri = request.getRequestURI();

// // // // // // 		String path = uri.replace("/api/admin/dev/coverage/files/", "");

// // // // // // 		Path file = Paths.get(System.getProperty("user.dir"))
// // // // // // 				.resolve("target/site/jacoco")
// // // // // // 				.resolve(path)
// // // // // // 				.normalize();

// // // // // // 		if (!Files.exists(file)) {
// // // // // // 			return ResponseEntity.notFound().build();
// // // // // // 		}

// // // // // // 		Resource resource = new UrlResource(file.toUri());

// // // // // // 		String contentType = Files.probeContentType(file);

// // // // // // 		return ResponseEntity.ok()
// // // // // // 				.contentType(contentType != null ? MediaType.parseMediaType(contentType) : MediaType.APPLICATION_OCTET_STREAM)
// // // // // // 				.body(resource);
// // // // // // 	}

// // // // // // 	@GetMapping("/coverage/performance")
// // // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // // 	public Map<String, Object> getPerformance() {

// // // // // // 		long start = System.currentTimeMillis();

// // // // // // 		// 🔥 ici tu peux simuler ou mesurer une vraie action
// // // // // // 		// (DB call, service call, etc.)
// // // // // // 		try {
// // // // // // 			Thread.sleep(10); // simulation rapide
// // // // // // 		} catch (InterruptedException ignored) {}

// // // // // // 		long duration = System.currentTimeMillis() - start;

// // // // // // 		return Map.of(
// // // // // // 				"responseTime", duration
// // // // // // 		);
// // // // // // 	}
// // // // // // }

// // // // // package com.fdjloto.api.controller.admin;

// // // // // import org.springframework.core.io.Resource;
// // // // // import org.springframework.core.io.UrlResource;
// // // // // import org.springframework.http.MediaType;
// // // // // import org.springframework.http.ResponseEntity;
// // // // // import org.springframework.security.access.prepost.PreAuthorize;
// // // // // import org.springframework.web.bind.annotation.*;

// // // // // import java.io.IOException;
// // // // // import java.nio.file.*;
// // // // // import java.util.Map;

// // // // // import jakarta.servlet.http.HttpServletRequest;

// // // // // @RestController
// // // // // @RequestMapping("/api/admin/dev")
// // // // // public class AdminDevController {

// // // // //     // @GetMapping("/coverage")
// // // // //     // @PreAuthorize("hasRole('ADMIN')")
// // // // //     // public ResponseEntity<Resource> getCoverage() throws IOException {

// // // // //     //     Path file = Paths.get(System.getProperty("user.dir"))
// // // // //     //             .resolve("target/site/jacoco/index.html")
// // // // //     //             .normalize();

// // // // //     //     System.out.println("📊 JaCoCo path: " + file.toAbsolutePath());
// // // // //     //     System.out.println("📊 Exists: " + Files.exists(file));

// // // // //     //     if (!Files.exists(file)) {
// // // // //     //         return ResponseEntity.notFound().build();
// // // // //     //     }

// // // // //     //     Resource resource = new UrlResource(file.toUri());

// // // // //     //     return ResponseEntity.ok()
// // // // //     //             .contentType(MediaType.TEXT_HTML)
// // // // //     //             .body(resource);
// // // // //     // }

// // // // // 	@GetMapping("/coverage")
// // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // 	public ResponseEntity<String> getCoverage() throws IOException {

// // // // // 		Path file = Paths.get(System.getProperty("user.dir"))
// // // // // 				.resolve("target/site/jacoco/index.html")
// // // // // 				.normalize();

// // // // // 		if (!Files.exists(file)) {
// // // // // 			return ResponseEntity.notFound().build();
// // // // // 		}

// // // // // 		String html = Files.readString(file);

// // // // // 		// 🔥 injection CSS custom
// // // // // 		String css = """
// // // // // 			<style>
// // // // // 				body {
// // // // // 					background:#0b1220;
// // // // // 					color:#e5e7eb;
// // // // // 					font-family:Arial;
// // // // // 				}
// // // // // 				table {
// // // // // 					background:#111827;
// // // // // 					border-radius:10px;
// // // // // 					overflow:hidden;
// // // // // 				}
// // // // // 				th {
// // // // // 					background:#1f2937;
// // // // // 					color:#9ca3af;
// // // // // 				}
// // // // // 				tr:hover {
// // // // // 					background:rgba(59,130,246,0.1);
// // // // // 				}
// // // // // 				a {
// // // // // 					color:#60a5fa;
// // // // // 				}
// // // // // 			</style>
// // // // // 		""";

// // // // // 		html = html.replace("</head>", css + "</head>");

// // // // // 		return ResponseEntity.ok()
// // // // // 				.contentType(MediaType.TEXT_HTML)
// // // // // 				.body(html);
// // // // // 	}

// // // // //     // 🔥 VERSION SAFE + ROBUSTE
// // // // //     @GetMapping("/coverage/summary")
// // // // //     @PreAuthorize("hasRole('ADMIN')")
// // // // //     public Map<String, Object> getCoverageSummary() {

// // // // //         try {
// // // // //             Path file = Paths.get(System.getProperty("user.dir"))
// // // // //                     .resolve("target/site/jacoco/index.html");

// // // // //             if (!Files.exists(file)) {
// // // // //                 return Map.of(
// // // // //                         "coverage", "N/A",
// // // // //                         "error", "JaCoCo report not found"
// // // // //                 );
// // // // //             }

// // // // //             String content = Files.readString(file);

// // // // //             int index = content.indexOf("Total");

// // // // //             if (index == -1) {
// // // // //                 return Map.of(
// // // // //                         "coverage", "N/A",
// // // // //                         "error", "Coverage not found in report"
// // // // //                 );
// // // // //             }

// // // // //             int end = Math.min(index + 200, content.length());

// // // // //             String snippet = content.substring(index, end);

// // // // //             return Map.of(
// // // // //                     "coverage", snippet
// // // // //             );

// // // // //         } catch (Exception e) {

// // // // //             return Map.of(
// // // // //                     "coverage", "N/A",
// // // // //                     "error", e.getMessage()
// // // // //             );
// // // // //         }
// // // // //     }

// // // // // 	@GetMapping("/coverage/files/**")
// // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // 	public ResponseEntity<Resource> getCoverageFiles(HttpServletRequest request) throws IOException {

// // // // // 		String uri = request.getRequestURI();

// // // // // 		String path = uri.replace("/api/admin/dev/coverage/files/", "");

// // // // // 		Path file = Paths.get(System.getProperty("user.dir"))
// // // // // 				.resolve("target/site/jacoco")
// // // // // 				.resolve(path)
// // // // // 				.normalize();

// // // // // 		if (!Files.exists(file)) {
// // // // // 			return ResponseEntity.notFound().build();
// // // // // 		}

// // // // // 		Resource resource = new UrlResource(file.toUri());

// // // // // 		String contentType = Files.probeContentType(file);

// // // // // 		return ResponseEntity.ok()
// // // // // 				.contentType(contentType != null ? MediaType.parseMediaType(contentType) : MediaType.APPLICATION_OCTET_STREAM)
// // // // // 				.body(resource);
// // // // // 	}

// // // // // 	@GetMapping("/coverage/performance")
// // // // // 	@PreAuthorize("hasRole('ADMIN')")
// // // // // 	public Map<String, Object> getPerformance() {

// // // // // 		long start = System.currentTimeMillis();

// // // // // 		// 🔥 ici tu peux simuler ou mesurer une vraie action
// // // // // 		// (DB call, service call, etc.)
// // // // // 		try {
// // // // // 			Thread.sleep(10); // simulation rapide
// // // // // 		} catch (InterruptedException ignored) {}

// // // // // 		long duration = System.currentTimeMillis() - start;

// // // // // 		return Map.of(
// // // // // 				"responseTime", duration
// // // // // 		);
// // // // // 	}
// // // // // }


// // // // package com.fdjloto.api.controller.admin;

// // // // import org.springframework.core.io.Resource;
// // // // import org.springframework.core.io.UrlResource;
// // // // import org.springframework.http.MediaType;
// // // // import org.springframework.http.ResponseEntity;
// // // // import org.springframework.security.access.prepost.PreAuthorize;
// // // // import org.springframework.web.bind.annotation.*;

// // // // import jakarta.servlet.http.HttpServletRequest;
// // // // import java.io.IOException;
// // // // import java.nio.file.*;
// // // // import java.util.Map;

// // // // @RestController
// // // // @RequestMapping("/api/admin/dev")
// // // // public class AdminDevController {

// // // //     private final Path BASE_PATH = Paths.get(System.getProperty("user.dir"))
// // // //             .resolve("target/site/jacoco")
// // // //             .normalize();

// // // //     // =========================
// // // //     // 🔥 MAIN COVERAGE (HTML)
// // // //     // =========================
// // // //     @GetMapping("/coverage")
// // // //     @PreAuthorize("hasRole('ADMIN')")
// // // //     public ResponseEntity<String> getCoverage() throws IOException {

// // // //         Path file = BASE_PATH.resolve("index.html");

// // // //         if (!Files.exists(file)) {
// // // //             return ResponseEntity.notFound().build();
// // // //         }

// // // //         String html = Files.readString(file);

// // // //         // 🔥 CSS DARK MODE
// // // //         String css = """
// // // //             <style>
// // // //                 body {
// // // //                     background:#0b1220;
// // // //                     color:#e5e7eb;
// // // //                     font-family:Arial;
// // // //                 }
// // // //                 table {
// // // //                     background:#111827;
// // // //                     border-radius:10px;
// // // //                     overflow:hidden;
// // // //                 }
// // // //                 th {
// // // //                     background:#1f2937;
// // // //                     color:#9ca3af;
// // // //                 }
// // // //                 tr:hover {
// // // //                     background:rgba(59,130,246,0.1);
// // // //                 }
// // // //                 a {
// // // //                     color:#60a5fa;
// // // //                 }
// // // //             </style>
// // // //         """;

// // // //         html = html.replace("</head>", css + "</head>");

// // // //         // 🔥 FIX LIENS (CRITIQUE)
// // // //         html = html.replaceAll(
// // // //                 "(href|src)=\"(?!http|/api)([^\"]+)\"",
// // // //                 "$1=\"/api/admin/dev/coverage/files/$2\""
// // // //         );

// // // //         return ResponseEntity.ok()
// // // //                 .contentType(MediaType.TEXT_HTML)
// // // //                 .body(html);
// // // //     }

// // // //     // =========================
// // // //     // 🔥 FILE SERVER (HTML + GIF + CSS + JS)
// // // //     // =========================
// // // //     @GetMapping("/coverage/files/**")
// // // //     @PreAuthorize("hasRole('ADMIN')")
// // // //     public ResponseEntity<?> getCoverageFiles(HttpServletRequest request) throws IOException {

// // // //         String uri = request.getRequestURI();
// // // //         String path = uri.replace("/api/admin/dev/coverage/files/", "");

// // // //         Path file = BASE_PATH.resolve(path).normalize();

// // // //         // 🔐 sécurité anti traversal
// // // //         if (!file.startsWith(BASE_PATH)) {
// // // //             return ResponseEntity.badRequest().build();
// // // //         }

// // // //         // 🔥 fallback jacoco-resources (IMPORTANT)
// // // //         if (!Files.exists(file)) {
// // // //             Path fallback = BASE_PATH.resolve("jacoco-resources")
// // // //                     .resolve(path)
// // // //                     .normalize();

// // // //             if (Files.exists(fallback)) {
// // // //                 file = fallback;
// // // //             } else {
// // // //                 return ResponseEntity.notFound().build();
// // // //             }
// // // //         }

// // // //         // 🔥 si HTML → rewrite liens aussi
// // // //         if (file.toString().endsWith(".html")) {

// // // //             String html = Files.readString(file);

// // // //             html = html.replaceAll(
// // // //                     "(href|src)=\"(?!http|/api)([^\"]+)\"",
// // // //                     "$1=\"/api/admin/dev/coverage/files/$2\""
// // // //             );

// // // //             return ResponseEntity.ok()
// // // //                     .contentType(MediaType.TEXT_HTML)
// // // //                     .body(html);
// // // //         }

// // // //         // 🔥 sinon (gif, css, js...)
// // // //         Resource resource = new UrlResource(file.toUri());

// // // //         String contentType = Files.probeContentType(file);

// // // //         return ResponseEntity.ok()
// // // //                 .contentType(contentType != null
// // // //                         ? MediaType.parseMediaType(contentType)
// // // //                         : MediaType.APPLICATION_OCTET_STREAM)
// // // //                 .body(resource);
// // // //     }

// // // //     // =========================
// // // //     // 📊 SUMMARY
// // // //     // =========================
// // // //     @GetMapping("/coverage/summary")
// // // //     @PreAuthorize("hasRole('ADMIN')")
// // // //     public Map<String, Object> getCoverageSummary() {

// // // //         try {
// // // //             Path file = BASE_PATH.resolve("index.html");

// // // //             if (!Files.exists(file)) {
// // // //                 return Map.of("coverage", "N/A", "error", "JaCoCo report not found");
// // // //             }

// // // //             String content = Files.readString(file);

// // // //             int index = content.indexOf("Total");

// // // //             if (index == -1) {
// // // //                 return Map.of("coverage", "N/A", "error", "Coverage not found");
// // // //             }

// // // //             String snippet = content.substring(index, Math.min(index + 200, content.length()));

// // // //             return Map.of("coverage", snippet);

// // // //         } catch (Exception e) {
// // // //             return Map.of("coverage", "N/A", "error", e.getMessage());
// // // //         }
// // // //     }

// // // //     // =========================
// // // //     // ⚡ PERFORMANCE
// // // //     // =========================
// // // //     @GetMapping("/coverage/performance")
// // // //     @PreAuthorize("hasRole('ADMIN')")
// // // //     public Map<String, Object> getPerformance() {

// // // //         long start = System.currentTimeMillis();

// // // //         try {
// // // //             Thread.sleep(10);
// // // //         } catch (InterruptedException ignored) {}

// // // //         long duration = System.currentTimeMillis() - start;

// // // //         return Map.of("responseTime", duration);
// // // //     }
// // // // }

// // // package com.fdjloto.api.controller.admin;

// // // import org.springframework.core.io.Resource;
// // // import org.springframework.core.io.UrlResource;
// // // import org.springframework.http.MediaType;
// // // import org.springframework.http.ResponseEntity;
// // // import org.springframework.security.access.prepost.PreAuthorize;
// // // import org.springframework.web.bind.annotation.*;

// // // import jakarta.servlet.http.HttpServletRequest;
// // // import java.io.IOException;
// // // import java.nio.file.*;
// // // import java.util.Map;
// // // import java.util.Optional;
// // // import java.util.stream.Stream;

// // // @RestController
// // // @RequestMapping("/api/admin/dev")
// // // public class AdminDevController {

// // //     private final Path BASE_PATH = Paths.get(System.getProperty("user.dir"))
// // //             .resolve("target/site/jacoco")
// // //             .normalize();

// // //     // =========================
// // //     // 🔥 MAIN COVERAGE (HTML)
// // //     // =========================
// // //     @GetMapping("/coverage")
// // //     @PreAuthorize("hasRole('ADMIN')")
// // //     public ResponseEntity<String> getCoverage() throws IOException {

// // //         Path file = BASE_PATH.resolve("index.html");

// // //         if (!Files.exists(file)) {
// // //             return ResponseEntity.notFound().build();
// // //         }

// // //         String html = Files.readString(file);

// // //         // 🎨 DARK MODE
// // //         String css = """
// // //             <style>
// // //                 body {
// // //                     background:#0b1220;
// // //                     color:#e5e7eb;
// // //                     font-family:Arial;
// // //                 }
// // //                 table {
// // //                     background:#111827;
// // //                     border-radius:10px;
// // //                     overflow:hidden;
// // //                 }
// // //                 th {
// // //                     background:#1f2937;
// // //                     color:#9ca3af;
// // //                 }
// // //                 tr:hover {
// // //                     background:rgba(59,130,246,0.1);
// // //                 }
// // //                 a {
// // //                     color:#60a5fa;
// // //                 }
// // //             </style>
// // //         """;

// // //         html = html.replace("</head>", css + "</head>");

// // //         // 🔥 REWRITE liens
// // //         html = rewriteLinks(html);

// // //         return ResponseEntity.ok()
// // //                 .contentType(MediaType.TEXT_HTML)
// // //                 .body(html);
// // //     }

// // //     // =========================
// // //     // 🔥 FILE SERVER
// // //     // =========================
// // //     @GetMapping("/coverage/files/**")
// // //     @PreAuthorize("hasRole('ADMIN')")
// // //     public ResponseEntity<?> getCoverageFiles(HttpServletRequest request) throws IOException {

// // //         String uri = request.getRequestURI();
// // //         String path = uri.replace("/api/admin/dev/coverage/files/", "");

// // //         Path file = BASE_PATH.resolve(path).normalize();

// // //         // 🔐 sécurité anti path traversal
// // //         if (!file.startsWith(BASE_PATH)) {
// // //             return ResponseEntity.badRequest().build();
// // //         }

// // //         // 🔥 1. fichier direct
// // //         if (!Files.exists(file)) {

// // //             // 🔥 2. fallback jacoco-resources
// // //             Path fallback = BASE_PATH.resolve("jacoco-resources")
// // //                     .resolve(path)
// // //                     .normalize();

// // //             if (Files.exists(fallback)) {
// // //                 file = fallback;
// // //             } else {

// // //                 // 🔥 3. fallback GLOBAL (ultra important)
// // //                 try (Stream<Path> paths = Files.walk(BASE_PATH)) {
// // //                     Optional<Path> found = paths
// // //                             .filter(p -> p.getFileName().toString().equals(path))
// // //                             .findFirst();

// // //                     if (found.isPresent()) {
// // //                         file = found.get();
// // //                     } else {
// // //                         return ResponseEntity.notFound().build();
// // //                     }
// // //                 }
// // //             }
// // //         }

// // //         // =========================
// // //         // HTML → rewrite links
// // //         // =========================
// // //         if (file.toString().endsWith(".html")) {

// // //             String html = Files.readString(file);
// // //             html = rewriteLinks(html);

// // //             return ResponseEntity.ok()
// // //                     .contentType(MediaType.TEXT_HTML)
// // //                     .body(html);
// // //         }

// // //         // =========================
// // //         // STATIC FILES (gif, css...)
// // //         // =========================
// // //         Resource resource = new UrlResource(file.toUri());

// // //         String contentType = Files.probeContentType(file);

// // //         return ResponseEntity.ok()
// // //                 .contentType(contentType != null
// // //                         ? MediaType.parseMediaType(contentType)
// // //                         : MediaType.APPLICATION_OCTET_STREAM)
// // //                 .body(resource);
// // //     }

// // //     // =========================
// // //     // 📊 SUMMARY
// // //     // =========================
// // //     @GetMapping("/coverage/summary")
// // //     @PreAuthorize("hasRole('ADMIN')")
// // //     public Map<String, Object> getCoverageSummary() {

// // //         try {
// // //             Path file = BASE_PATH.resolve("index.html");

// // //             if (!Files.exists(file)) {
// // //                 return Map.of("coverage", "N/A", "error", "JaCoCo report not found");
// // //             }

// // //             String content = Files.readString(file);

// // //             int index = content.indexOf("Total");

// // //             if (index == -1) {
// // //                 return Map.of("coverage", "N/A", "error", "Coverage not found");
// // //             }

// // //             String snippet = content.substring(index, Math.min(index + 200, content.length()));

// // //             return Map.of("coverage", snippet);

// // //         } catch (Exception e) {
// // //             return Map.of("coverage", "N/A", "error", e.getMessage());
// // //         }
// // //     }

// // //     // =========================
// // //     // ⚡ PERFORMANCE
// // //     // =========================
// // //     @GetMapping("/coverage/performance")
// // //     @PreAuthorize("hasRole('ADMIN')")
// // //     public Map<String, Object> getPerformance() {

// // //         long start = System.currentTimeMillis();

// // //         try {
// // //             Thread.sleep(10);
// // //         } catch (InterruptedException ignored) {}

// // //         long duration = System.currentTimeMillis() - start;

// // //         return Map.of("responseTime", duration);
// // //     }

// // //     // =========================
// // //     // 🔧 UTIL
// // //     // =========================
// // //     private String rewriteLinks(String html) {
// // //         return html.replaceAll(
// // //                 "(href|src)=\"(?!http|/api)([^\"]+)\"",
// // //                 "$1=\"/api/admin/dev/coverage/files/$2\""
// // //         );
// // //     }
// // // }

// // package com.fdjloto.api.controller.admin;

// // import org.springframework.core.io.Resource;
// // import org.springframework.core.io.UrlResource;
// // import org.springframework.http.MediaType;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.security.access.prepost.PreAuthorize;
// // import org.springframework.web.bind.annotation.*;

// // import jakarta.servlet.http.HttpServletRequest;
// // import java.io.IOException;
// // import java.nio.file.*;
// // import java.util.Map;
// // import java.util.Optional;
// // import java.util.stream.Stream;

// // @RestController
// // @RequestMapping("/api/admin/dev")
// // public class AdminDevController {

// //     private final Path BASE_PATH = Paths.get(System.getProperty("user.dir"))
// //             .resolve("target/site/jacoco")
// //             .normalize();

// //     // =========================
// //     // 🔥 MAIN COVERAGE
// //     // =========================
// //     @GetMapping("/coverage")
// //     @PreAuthorize("hasRole('ADMIN')")
// //     public ResponseEntity<String> getCoverage() throws IOException {

// //         Path file = BASE_PATH.resolve("index.html");

// //         if (!Files.exists(file)) {
// //             return ResponseEntity.notFound().build();
// //         }

// //         String html = Files.readString(file);

// //         html = injectCss(html);      // ✅ FIX
// //         html = rewriteLinks(html);

// //         return ResponseEntity.ok()
// //                 .contentType(MediaType.TEXT_HTML)
// //                 .body(html);
// //     }

// //     // =========================
// //     // 🔥 FILE SERVER
// //     // =========================
// //     @GetMapping("/coverage/files/**")
// //     @PreAuthorize("hasRole('ADMIN')")
// //     public ResponseEntity<?> getCoverageFiles(HttpServletRequest request) throws IOException {

// //         String uri = request.getRequestURI();
// //         String path = uri.replace("/api/admin/dev/coverage/files/", "");

// //         Path file = BASE_PATH.resolve(path).normalize();

// //         // 🔐 sécurité anti traversal
// //         if (!file.startsWith(BASE_PATH)) {
// //             return ResponseEntity.badRequest().build();
// //         }

// //         // =========================
// //         // 🔥 RESOLUTION FICHIER
// //         // =========================
// //         if (!Files.exists(file)) {

// //             // 1️⃣ jacoco-resources
// //             Path fallback = BASE_PATH.resolve("jacoco-resources")
// //                     .resolve(path)
// //                     .normalize();

// //             if (Files.exists(fallback)) {
// //                 file = fallback;
// //             } else {

// //                 // 2️⃣ fallback global (très important)
// //                 try (Stream<Path> paths = Files.walk(BASE_PATH)) {
// //                     Optional<Path> found = paths
// //                             .filter(p -> p.getFileName().toString().equals(path))
// //                             .findFirst();

// //                     if (found.isPresent()) {
// //                         file = found.get();
// //                     } else {
// //                         return ResponseEntity.notFound().build();
// //                     }
// //                 }
// //             }
// //         }

// //         // =========================
// //         // 🔥 HTML (inject CSS + rewrite)
// //         // =========================
// //         if (file.toString().endsWith(".html")) {

// //             String html = Files.readString(file);

// //             html = injectCss(html);   // ✅ FIX CRITIQUE
// //             html = rewriteLinks(html);

// //             return ResponseEntity.ok()
// //                     .contentType(MediaType.TEXT_HTML)
// //                     .body(html);
// //         }

// //         // =========================
// //         // 📁 STATIC FILES
// //         // =========================
// //         Resource resource = new UrlResource(file.toUri());

// //         String contentType = Files.probeContentType(file);

// //         return ResponseEntity.ok()
// //                 .contentType(contentType != null
// //                         ? MediaType.parseMediaType(contentType)
// //                         : MediaType.APPLICATION_OCTET_STREAM)
// //                 .body(resource);
// //     }

// //     // =========================
// //     // 📊 SUMMARY
// //     // =========================
// //     @GetMapping("/coverage/summary")
// //     @PreAuthorize("hasRole('ADMIN')")
// //     public Map<String, Object> getCoverageSummary() {

// //         try {
// //             Path file = BASE_PATH.resolve("index.html");

// //             if (!Files.exists(file)) {
// //                 return Map.of("coverage", "N/A", "error", "JaCoCo report not found");
// //             }

// //             String content = Files.readString(file);

// //             int index = content.indexOf("Total");

// //             if (index == -1) {
// //                 return Map.of("coverage", "N/A", "error", "Coverage not found");
// //             }

// //             String snippet = content.substring(index, Math.min(index + 200, content.length()));

// //             return Map.of("coverage", snippet);

// //         } catch (Exception e) {
// //             return Map.of("coverage", "N/A", "error", e.getMessage());
// //         }
// //     }

// //     // =========================
// //     // ⚡ PERFORMANCE
// //     // =========================
// //     @GetMapping("/coverage/performance")
// //     @PreAuthorize("hasRole('ADMIN')")
// //     public Map<String, Object> getPerformance() {

// //         long start = System.currentTimeMillis();

// //         try {
// //             Thread.sleep(10);
// //         } catch (InterruptedException ignored) {}

// //         long duration = System.currentTimeMillis() - start;

// //         return Map.of("responseTime", duration);
// //     }

// //     // =========================
// //     // 🎨 CSS GLOBAL
// //     // =========================
// //     private String injectCss(String html) {

// //         String css = """
// //             <style>
// //                 body {
// //                     background:#0b1220 !important;
// //                     color:#e5e7eb !important;
// //                     font-family:Arial;
// //                 }

// //                 h1, h2, h3, h4 {
// //                     color:#f9fafb !important;
// //                 }

// //                 table {
// //                     background:#111827 !important;
// //                     border-radius:10px;
// //                     overflow:hidden;
// //                 }

// //                 th {
// //                     background:#1f2937 !important;
// //                     color:#d1d5db !important;
// //                 }

// //                 td {
// //                     color:#e5e7eb !important;
// //                 }

// //                 tr:hover {
// //                     background:rgba(59,130,246,0.1);
// //                 }

// //                 a {
// //                     color:#60a5fa !important;
// //                 }

// //                 .breadcrumb {
// //                     color:#93c5fd !important;
// //                 }

// //                 #header {
// //                     background:#0f172a !important;
// //                     color:#f9fafb !important;
// //                 }

// //             </style>
// //         """;

// //         return html.replace("</head>", css + "</head>");
// //     }

// //     // =========================
// //     // 🔗 REWRITE LIENS
// //     // =========================
// //     private String rewriteLinks(String html) {
// //         return html.replaceAll(
// //                 "(href|src)=\"(?!http|/api)([^\"]+)\"",
// //                 "$1=\"/api/admin/dev/coverage/files/$2\""
// //         );
// //     }
// // }

// package com.fdjloto.api.controller.admin;

// import org.springframework.core.io.Resource;
// import org.springframework.core.io.UrlResource;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.*;

// import jakarta.servlet.http.HttpServletRequest;
// import java.io.IOException;
// import java.nio.file.*;
// import java.util.Map;
// import java.util.Optional;
// import java.util.stream.Stream;

// @RestController
// @RequestMapping("/api/admin/dev")
// public class AdminDevController {

//     private final Path BASE_PATH = Paths.get(System.getProperty("user.dir"))
//             .resolve("target/site/jacoco")
//             .normalize();

//     // =========================
//     // 🔥 MAIN COVERAGE
//     // =========================
//     @GetMapping("/coverage")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<String> getCoverage() throws IOException {

//         Path file = BASE_PATH.resolve("index.html");

//         if (!Files.exists(file)) {
//             return ResponseEntity.notFound().build();
//         }

//         String html = Files.readString(file);

//         html = injectCss(html);
//         html = rewriteLinks(html);

//         return ResponseEntity.ok()
//                 .contentType(MediaType.TEXT_HTML)
//                 .body(html);
//     }

//     // =========================
//     // 🔥 FILE SERVER
//     // =========================
//     @GetMapping("/coverage/files/**")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<?> getCoverageFiles(HttpServletRequest request) throws IOException {

//         String uri = request.getRequestURI();
//         String path = uri.replace("/api/admin/dev/coverage/files/", "");

//         Path file = BASE_PATH.resolve(path).normalize();

//         // 🔐 sécurité anti traversal
//         if (!file.startsWith(BASE_PATH)) {
//             return ResponseEntity.badRequest().build();
//         }

//         // 🔥 résolution fichier
//         if (!Files.exists(file)) {

//             // fallback jacoco-resources
//             Path fallback = BASE_PATH.resolve("jacoco-resources")
//                     .resolve(path)
//                     .normalize();

//             if (Files.exists(fallback)) {
//                 file = fallback;
//             } else {
//                 // fallback global
//                 try (Stream<Path> paths = Files.walk(BASE_PATH)) {
//                     Optional<Path> found = paths
//                             .filter(p -> p.getFileName().toString().equals(path))
//                             .findFirst();

//                     if (found.isPresent()) {
//                         file = found.get();
//                     } else {
//                         return ResponseEntity.notFound().build();
//                     }
//                 }
//             }
//         }

//         // =========================
//         // 🔥 HTML (dark + rewrite)
//         // =========================
//         if (file.toString().endsWith(".html")) {

//             String html = Files.readString(file);

//             html = injectCss(html);   // 🔥 CRUCIAL
//             html = rewriteLinks(html);

//             return ResponseEntity.ok()
//                     .contentType(MediaType.TEXT_HTML)
//                     .body(html);
//         }

//         // =========================
//         // 📁 STATIC FILES
//         // =========================
//         Resource resource = new UrlResource(file.toUri());

//         String contentType = Files.probeContentType(file);

//         return ResponseEntity.ok()
//                 .contentType(contentType != null
//                         ? MediaType.parseMediaType(contentType)
//                         : MediaType.APPLICATION_OCTET_STREAM)
//                 .body(resource);
//     }

//     // =========================
//     // 📊 SUMMARY
//     // =========================
//     @GetMapping("/coverage/summary")
//     @PreAuthorize("hasRole('ADMIN')")
//     public Map<String, Object> getCoverageSummary() {

//         try {
//             Path file = BASE_PATH.resolve("index.html");

//             if (!Files.exists(file)) {
//                 return Map.of("coverage", "N/A", "error", "JaCoCo report not found");
//             }

//             String content = Files.readString(file);

//             int index = content.indexOf("Total");

//             if (index == -1) {
//                 return Map.of("coverage", "N/A", "error", "Coverage not found");
//             }

//             String snippet = content.substring(index, Math.min(index + 200, content.length()));

//             return Map.of("coverage", snippet);

//         } catch (Exception e) {
//             return Map.of("coverage", "N/A", "error", e.getMessage());
//         }
//     }

//     // =========================
//     // ⚡ PERFORMANCE
//     // =========================
//     @GetMapping("/coverage/performance")
//     @PreAuthorize("hasRole('ADMIN')")
//     public Map<String, Object> getPerformance() {

//         long start = System.currentTimeMillis();

//         try {
//             Thread.sleep(10);
//         } catch (InterruptedException ignored) {}

//         long duration = System.currentTimeMillis() - start;

//         return Map.of("responseTime", duration);
//     }

//     // =========================
//     // 🎨 CSS GLOBAL FIX COMPLET
//     // =========================
// 	private String injectCss(String html) {

// 		String css = """
// 			<style>

// 				/* 🔥 GLOBAL */
// 				body {
// 					background:#0b1220 !important;
// 					color:#e5e7eb !important;
// 					font-family:Arial;
// 				}

// 				/* 🔥 HEADER JACOCO */
// 				#header, .header, .report, .breadcrumb {
// 					background:#0f172a !important;
// 					color:#f9fafb !important;
// 					border-bottom:1px solid #1f2937 !important;
// 				}

// 				#header a {
// 					color:#60a5fa !important;
// 				}

// 				/* 🔥 TITRES */
// 				h1, h2, h3, h4 {
// 					color:#f9fafb !important;
// 				}

// 				/* 🔥 BARRES JACOCO (LE VRAI FIX) */
// 				.el_report, .el_package, .el_class {
// 					background:#111827 !important;
// 					color:#f9fafb !important;
// 				}

// 				/* 🔥 TABLE */
// 				table {
// 					background:#111827 !important;
// 					border-radius:10px;
// 					overflow:hidden;
// 				}

// 				th {
// 					background:#1f2937 !important;
// 					color:#d1d5db !important;
// 				}

// 				td {
// 					color:#e5e7eb !important;
// 				}

// 				tr:hover {
// 					background:rgba(59,130,246,0.1);
// 				}

// 				/* 🔥 LIENS */
// 				a {
// 					color:#60a5fa !important;
// 				}

// 				/* 🔥 FIX GLOBAL anti fond blanc */
// 				div, span {
// 					background-color: transparent !important;
// 				}

// 				* {
// 					background-color: inherit !important;
// 				}

// 			</style>
// 		""";

// 		return html.replace("</head>", css + "</head>");
// 	}

//     // =========================
//     // 🔗 REWRITE LIENS
//     // =========================
//     private String rewriteLinks(String html) {
//         return html.replaceAll(
//                 "(href|src)=\"(?!http|/api)([^\"]+)\"",
//                 "$1=\"/api/admin/dev/coverage/files/$2\""
//         );
//     }
// }



package com.fdjloto.api.controller.admin;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/admin/dev")
public class AdminDevController {

    private final Path BASE_PATH = Paths.get(System.getProperty("user.dir"))
            .resolve("target/site/jacoco")
            .normalize();

    // =========================
    // 🔥 MAIN COVERAGE (FIXED)
    // =========================
    @GetMapping("/coverage")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getCoverage() throws IOException {

        Path file = BASE_PATH.resolve("index.html");

        if (!Files.exists(file)) {
            return ResponseEntity.notFound().build();
        }

        String html = Files.readString(file);

        // ✅ FIX CRITIQUE → base href
        html = html.replace("<head>",
                "<head><base href=\"/api/admin/dev/coverage/files/\">"
        );

        html = injectCss(html);

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

    // =========================
    // 🔥 FILE SERVER (inchangé)
    // =========================
    @GetMapping("/coverage/files/**")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getCoverageFiles(HttpServletRequest request) throws IOException {

        String uri = request.getRequestURI();
        String path = uri.replace("/api/admin/dev/coverage/files/", "");

        Path file = BASE_PATH.resolve(path).normalize();

        // 🔐 sécurité anti traversal
        if (!file.startsWith(BASE_PATH)) {
            return ResponseEntity.badRequest().build();
        }

        // 🔥 résolution fichier
        if (!Files.exists(file)) {

            // fallback jacoco-resources
            Path fallback = BASE_PATH.resolve("jacoco-resources")
                    .resolve(path)
                    .normalize();

            if (Files.exists(fallback)) {
                file = fallback;
            } else {
                // fallback global
                try (Stream<Path> paths = Files.walk(BASE_PATH)) {
                    Optional<Path> found = paths
                            .filter(p -> p.getFileName().toString().equals(path))
                            .findFirst();

                    if (found.isPresent()) {
                        file = found.get();
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }
            }
        }

        // =========================
        // 🔥 HTML (dark uniquement)
        // =========================
        if (file.toString().endsWith(".html")) {

            String html = Files.readString(file);

            html = injectCss(html); // ✅ plus de rewriteLinks

            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(html);
        }

        // =========================
        // 📁 STATIC FILES
        // =========================
        Resource resource = new UrlResource(file.toUri());

        String contentType = Files.probeContentType(file);

        return ResponseEntity.ok()
                .contentType(contentType != null
                        ? MediaType.parseMediaType(contentType)
                        : MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    // =========================
    // 📊 SUMMARY (inchangé)
    // =========================
    @GetMapping("/coverage/summary")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> getCoverageSummary() {

        try {
            Path file = BASE_PATH.resolve("index.html");

            if (!Files.exists(file)) {
                return Map.of("coverage", "N/A", "error", "JaCoCo report not found");
            }

            String content = Files.readString(file);

            int index = content.indexOf("Total");

            if (index == -1) {
                return Map.of("coverage", "N/A", "error", "Coverage not found");
            }

            String snippet = content.substring(index, Math.min(index + 200, content.length()));

            return Map.of("coverage", snippet);

        } catch (Exception e) {
            return Map.of("coverage", "N/A", "error", e.getMessage());
        }
    }

    // =========================
    // ⚡ PERFORMANCE
    // =========================
    @GetMapping("/coverage/performance")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> getPerformance() {

        long start = System.currentTimeMillis();

        // try {
        //     Thread.sleep(10);
        // } catch (InterruptedException ignored) {}
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long duration = System.currentTimeMillis() - start;

        return Map.of("responseTime", duration);
    }

    // =========================
    // 🎨 CSS GLOBAL
    // =========================
    private String injectCss(String html) {

        String css = """
            <style>

                body {
                    background:#0b1220 !important;
                    color:#e5e7eb !important;
                    font-family:Arial;
                }

                #header, .header, .report, .breadcrumb {
                    background:#0f172a !important;
                    color:#f9fafb !important;
                    border-bottom:1px solid #1f2937 !important;
                }

                h1, h2, h3, h4 {
                    color:#f9fafb !important;
                }

                table {
                    background:#111827 !important;
                    border-radius:10px;
                    overflow:hidden;
                }

                th {
                    background:#1f2937 !important;
                    color:#d1d5db !important;
                }

                td {
                    color:#e5e7eb !important;
                }

                tr:hover {
                    background:rgba(59,130,246,0.1);
                }

                a {
                    color:#60a5fa !important;
                }

                * {
                    background-color: inherit !important;
                }

            </style>
        """;

        return html.replace("</head>", css + "</head>");
    }
}
