export const html = `
<!DOCTYPE html>
<html lang="en">
<head>
  <script>
    function changeText(text) {
      var h1 = document.getElementById("title");
      h1.innerHTML = text;
    }
  </script>
</head>
<body>
<h1 id="title">Hello World</h1>
</body>
</html>
`;
